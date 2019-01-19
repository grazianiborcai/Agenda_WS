package br.com.gda.payService.payCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusEnforceEntityCateg;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusNodeUpsertAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusNodeUpsertPhone;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusUpdate;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusUpdatePerson;
import br.com.gda.payService.payCustomer.model.action.StdPaycusEnforceAddressKey;
import br.com.gda.payService.payCustomer.model.action.StdPaycusEnforceLChanged;
import br.com.gda.payService.payCustomer.model.action.StdPaycusEnforcePhoneKey;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckExist;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckOwner;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckPerson;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckPersonChange;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckWrite;

public final class RootPaycusUpdate implements DeciTree<PaycusInfo> {
	private DeciTree<PaycusInfo> tree;
	
	
	public RootPaycusUpdate(DeciTreeOption<PaycusInfo> option) {
		DeciTreeHelperOption<PaycusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PaycusInfo> buildDecisionChecker(DeciTreeOption<PaycusInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean NOT_CHANGED = true;
		
		List<ModelChecker<PaycusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaycusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PaycusCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PaycusCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PaycusCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PaycusCheckPerson(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = NOT_CHANGED;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new PaycusCheckPersonChange(checkerOption);
		queue.add(checker);
		
		//TODO: verificar se Addresses e customer possuem o mesmo codigo
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PaycusInfo>> buildActionsOnPassed(DeciTreeOption<PaycusInfo> option) {
		List<ActionStd<PaycusInfo>> actions = new ArrayList<>();
		//TODO: Verificar cod_phone e cod_address
		ActionStd<PaycusInfo> enforceLChanged = new StdPaycusEnforceLChanged(option);
		ActionLazy<PaycusInfo> enforceEntityCateg = new LazyPaycusEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> updateCus = new LazyPaycusUpdate(option.conn, option.schemaName);		
		ActionLazy<PaycusInfo> updatePerson = new LazyPaycusUpdatePerson(option.conn, option.schemaName);
		ActionStd<PaycusInfo> enforceAddressKey = new StdPaycusEnforceAddressKey(option);
		ActionLazy<PaycusInfo> upsertAddress = new LazyPaycusNodeUpsertAddress(option.conn, option.schemaName);		
		ActionStd<PaycusInfo> enforcePhoneKey = new StdPaycusEnforcePhoneKey(option);
		ActionLazy<PaycusInfo> upsertPhone = new LazyPaycusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<PaycusInfo> select = new RootPaycusSelect(option).toAction();		
		
		enforceLChanged.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(updatePerson);
		updatePerson.addPostAction(updateCus);
		enforceAddressKey.addPostAction(upsertAddress);
		enforcePhoneKey.addPostAction(upsertPhone);
		
		actions.add(enforceLChanged);
		actions.add(enforceAddressKey);	
		actions.add(enforcePhoneKey);
		actions.add(select);	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PaycusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PaycusInfo> toAction() {
		return tree.toAction();
	}
}
