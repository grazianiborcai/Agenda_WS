package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusEnforceAddressKey;
import br.com.gda.business.customer.model.action.LazyCusEnforceEntityCateg;
import br.com.gda.business.customer.model.action.LazyCusEnforcePhoneKey;
import br.com.gda.business.customer.model.action.LazyCusInsert;
import br.com.gda.business.customer.model.action.LazyCusInsertPerson;
import br.com.gda.business.customer.model.action.LazyCusNodeUpsertAddress;
import br.com.gda.business.customer.model.action.LazyCusNodeUpsertPhone;
import br.com.gda.business.customer.model.action.StdCusEnforceLChanged;
import br.com.gda.business.customer.model.checker.CusCheckGenField;
import br.com.gda.business.customer.model.checker.CusCheckOwner;
import br.com.gda.business.customer.model.checker.CusCheckInsert;
import br.com.gda.business.customer.model.checker.CusCheckWriteAddress;
import br.com.gda.business.customer.model.checker.CusCheckWritePhone;
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

public final class RootCusInsert implements DeciTree<CusInfo> {
	private DeciTree<CusInfo> tree;
	
	
	public RootCusInsert(DeciTreeOption<CusInfo> option) {
		DeciTreeHelperOption<CusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CusInfo> buildDecisionChecker(DeciTreeOption<CusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CusCheckInsert();
		queue.add(checker);
		
		checker = new CusCheckGenField();
		queue.add(checker);
		
		checker = new CusCheckWritePhone();
		queue.add(checker);
		
		checker = new CusCheckWriteAddress();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		//TODO: verificar se Addresses e customer possuem o mesmo codigo
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<CusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<CusInfo>> buildActionsOnPassed(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> enforceLChanged = new StdCusEnforceLChanged(option);
		ActionLazy<CusInfo> enforceEntityCateg = new LazyCusEnforceEntityCateg(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertPerson = new LazyCusInsertPerson(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertCus = new LazyCusInsert(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceAddressKey = new LazyCusEnforceAddressKey(option.conn, option.schemaName);
		ActionLazy<CusInfo> upsertAddress = new LazyCusNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforcePhoneKey = new LazyCusEnforcePhoneKey(option.conn, option.schemaName);
		ActionLazy<CusInfo> upsertPhone = new LazyCusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<CusInfo> select = new RootCusSelect(option).toAction();		
		
		enforceLChanged.addPostAction(enforceEntityCateg);
		enforceEntityCateg.addPostAction(insertPerson);
		insertPerson.addPostAction(insertCus);		
		
		insertCus.addPostAction(enforceAddressKey);
		enforceAddressKey.addPostAction(upsertAddress);
		
		insertCus.addPostAction(enforcePhoneKey);
		enforcePhoneKey.addPostAction(upsertPhone);	
		
		actions.add(enforceLChanged);		
		actions.add(select);	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
