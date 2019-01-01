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
import br.com.gda.payService.payCustomer.model.action.LazyPayCusEnforceAddressKey;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusEnforceEntityCateg;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusEnforcePhoneKey;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusInsert;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusInsertPerson;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusNodeUpsertAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusNodeUpsertPhone;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusRootSelect;
import br.com.gda.payService.payCustomer.model.action.StdPayCusEnforceLChanged;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckInsert;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckOwner;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckTechField;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckWriteAddress;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckWritePhone;

public final class RootPayCusInsert implements DeciTree<PayCusInfo> {
	private DeciTree<PayCusInfo> tree;
	
	
	public RootPayCusInsert(DeciTreeOption<PayCusInfo> option) {
		DeciTreeHelperOption<PayCusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayCusInfo> buildDecisionChecker(DeciTreeOption<PayCusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PayCusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PayCusCheckInsert();
		queue.add(checker);
		
		checker = new PayCusCheckTechField();
		queue.add(checker);
		
		checker = new PayCusCheckWritePhone();
		queue.add(checker);
		
		checker = new PayCusCheckWriteAddress();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayCusCheckOwner(checkerOption);
		queue.add(checker);	
		
		//TODO: verificar se Addresses e customer possuem o mesmo codigo
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PayCusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PayCusInfo>> buildActionsOnPassed(DeciTreeOption<PayCusInfo> option) {
		List<ActionStd<PayCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PayCusInfo> enforceLChanged = new StdPayCusEnforceLChanged(option);
		ActionLazy<PayCusInfo> enforceEntityCateg = new LazyPayCusEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> insertPerson = new LazyPayCusInsertPerson(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> insertCus = new LazyPayCusInsert(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> enforceAddressKey = new LazyPayCusEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> upsertAddress = new LazyPayCusNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> enforcePhoneKey = new LazyPayCusEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> upsertPhone = new LazyPayCusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<PayCusInfo> selectCustomer = new LazyPayCusRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(insertPerson);
		insertPerson.addPostAction(insertCus);		
		
		insertCus.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(upsertAddress);
		
		insertCus.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(upsertPhone);	
		
		insertCus.addPostAction(selectCustomer);
		
		actions.add(enforceLChanged);	
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
}
