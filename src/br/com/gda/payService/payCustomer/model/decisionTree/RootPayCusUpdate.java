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
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusEnforceEntityCateg;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusNodeUpsertAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusNodeUpsertPhone;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusUpdate;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusUpdatePerson;
import br.com.gda.payService.payCustomer.model.action.StdPayCusEnforceAddressKey;
import br.com.gda.payService.payCustomer.model.action.StdPayCusEnforceLChanged;
import br.com.gda.payService.payCustomer.model.action.StdPayCusEnforcePhoneKey;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckExist;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckOwner;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckPerson;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckPersonChange;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckWrite;

public final class RootPayCusUpdate implements DeciTree<PayCusInfo> {
	private DeciTree<PayCusInfo> tree;
	
	
	public RootPayCusUpdate(DeciTreeOption<PayCusInfo> option) {
		DeciTreeHelperOption<PayCusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayCusInfo> buildDecisionChecker(DeciTreeOption<PayCusInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean NOT_CHANGED = true;
		
		List<ModelChecker<PayCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PayCusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PayCusCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayCusCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayCusCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayCusCheckPerson(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = NOT_CHANGED;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new PayCusCheckPersonChange(checkerOption);
		queue.add(checker);
		
		//TODO: verificar se Addresses e customer possuem o mesmo codigo
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayCusInfo>> buildActionsOnPassed(DeciTreeOption<PayCusInfo> option) {
		List<ActionStd<PayCusInfo>> actions = new ArrayList<>();
		//TODO: Verificar cod_phone e cod_address
		ActionStd<PayCusInfo> enforceLChanged = new StdPayCusEnforceLChanged(option);
		ActionLazy<PayCusInfo> enforceEntityCateg = new LazyPayCusEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> updateCus = new LazyPayCusUpdate(option.conn, option.schemaName);		
		ActionLazy<PayCusInfo> updatePerson = new LazyPayCusUpdatePerson(option.conn, option.schemaName);
		ActionStd<PayCusInfo> enforceAddressKey = new StdPayCusEnforceAddressKey(option);
		ActionLazy<PayCusInfo> upsertAddress = new LazyPayCusNodeUpsertAddress(option.conn, option.schemaName);		
		ActionStd<PayCusInfo> enforcePhoneKey = new StdPayCusEnforcePhoneKey(option);
		ActionLazy<PayCusInfo> upsertPhone = new LazyPayCusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<PayCusInfo> select = new RootPayCusSelect(option).toAction();		
		
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
	
	
	
	@Override public DeciResult<PayCusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayCusInfo> toAction() {
		return tree.toAction();
	}
}
