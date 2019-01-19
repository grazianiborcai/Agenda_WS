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
import br.com.gda.payService.payCustomer.model.action.LazyPaycusEnforceAddressKey;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusEnforceEntityCateg;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusEnforceLChanged;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusEnforcePersonKey;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusEnforcePhoneKey;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusInsert;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusInsertPerson;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusNodeUpsertAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusNodeUpsertPhone;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusRootSelect;
import br.com.gda.payService.payCustomer.model.action.StdPaycusMergeUser;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckUserAddress;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckUserPhone;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckUserTaken;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckInsert;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckOwner;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckTechField;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckUser;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckWriteAddress;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckWritePhone;

public final class RootPaycusInsert implements DeciTree<PaycusInfo> {
	private DeciTree<PaycusInfo> tree;
	
	
	public RootPaycusInsert(DeciTreeOption<PaycusInfo> option) {
		DeciTreeHelperOption<PaycusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PaycusInfo> buildDecisionChecker(DeciTreeOption<PaycusInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<PaycusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaycusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PaycusCheckInsert();
		queue.add(checker);
		
		checker = new PaycusCheckTechField();
		queue.add(checker);
		
		checker = new PaycusCheckWritePhone();
		queue.add(checker);
		
		checker = new PaycusCheckWriteAddress();
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
		checker = new PaycusCheckUser(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PaycusCheckUserAddress(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PaycusCheckUserPhone(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;		
		checker = new PaycusCheckUserTaken(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PaycusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PaycusInfo>> buildActionsOnPassed(DeciTreeOption<PaycusInfo> option) {
		List<ActionStd<PaycusInfo>> actions = new ArrayList<>();
		//TODO: inserir PAY_PARTNER
		ActionStd<PaycusInfo> mergeUser = new StdPaycusMergeUser(option);
		ActionLazy<PaycusInfo> enforceLChanged = new LazyPaycusEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> enforceEntityCateg = new LazyPaycusEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> enforcePersonKey = new LazyPaycusEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> insertPerson = new LazyPaycusInsertPerson(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> insertPayCus = new LazyPaycusInsert(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> enforceAddressKey = new LazyPaycusEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> upsertAddress = new LazyPaycusNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> enforcePhoneKey = new LazyPaycusEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> upsertPhone = new LazyPaycusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<PaycusInfo> selectCustomer = new LazyPaycusRootSelect(option.conn, option.schemaName);	
		
		mergeUser.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);
		insertPerson.addPostAction(insertPayCus);		
		
		insertPayCus.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(upsertAddress);
		
		insertPayCus.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(upsertPhone);	
		
		insertPayCus.addPostAction(selectCustomer);
		
		actions.add(mergeUser);	
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
}
