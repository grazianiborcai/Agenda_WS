package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusNodeUpdateL1;
import br.com.gda.business.customer.model.action.LazyCusNodeUpsertAddress;
import br.com.gda.business.customer.model.action.LazyCusNodeUpsertPhone;
import br.com.gda.business.customer.model.action.StdCusEnforceAddressKey;
import br.com.gda.business.customer.model.action.StdCusEnforceLChanged;
import br.com.gda.business.customer.model.action.StdCusEnforcePhoneKey;
import br.com.gda.business.customer.model.checker.CusCheckCpf;
import br.com.gda.business.customer.model.checker.CusCheckEmailChange;
import br.com.gda.business.customer.model.checker.CusCheckExist;
import br.com.gda.business.customer.model.checker.CusCheckGender;
import br.com.gda.business.customer.model.checker.CusCheckKey;
import br.com.gda.business.customer.model.checker.CusCheckOwner;
import br.com.gda.business.customer.model.checker.CusCheckWrite;
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

public final class RootCusUpdate implements DeciTree<CusInfo> {
	private DeciTree<CusInfo> tree;
	
	
	public RootCusUpdate(DeciTreeOption<CusInfo> option) {
		DeciTreeHelperOption<CusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CusInfo> buildDecisionChecker(DeciTreeOption<CusInfo> option) {
		final boolean NOT_CHANGED = true;
		final boolean EXIST_ON_DB = true;			
		final boolean KEY_NOT_NULL = true;	
		//final boolean IS_VALID = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CusCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;
		checker = new CusCheckKey(checkerOption);
		queue.add(checker);
		
		checker = new CusCheckCpf();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckGender(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = NOT_CHANGED;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckEmailChange(checkerOption);
		queue.add(checker);
		/*
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = IS_VALID;		
		checker = new CusCheckPhone1_(checkerOption);
		queue.add(checker);	
		*/
		
		//TODO: verificar se Addresses e customer possuem o mesmo codigo
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<CusInfo>> buildActionsOnPassed(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> enforceLChanged = new StdCusEnforceLChanged(option);
		ActionLazy<CusInfo> update = new LazyCusNodeUpdateL1(option.conn, option.schemaName);		
		ActionStd<CusInfo> enforceAddressKey = new StdCusEnforceAddressKey(option);
		ActionLazy<CusInfo> upsertAddress = new LazyCusNodeUpsertAddress(option.conn, option.schemaName);		
		ActionStd<CusInfo> enforcePhoneKey = new StdCusEnforcePhoneKey(option);
		ActionLazy<CusInfo> upsertPhone = new LazyCusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<CusInfo> select = new RootCusSelect(option).toAction();		
		
		enforceLChanged.addPostAction(update);
		enforceAddressKey.addPostAction(upsertAddress);
		enforcePhoneKey.addPostAction(upsertPhone);
		
		actions.add(enforceLChanged);
		actions.add(enforceAddressKey);	
		actions.add(enforcePhoneKey);
		actions.add(select);	
		return actions;
		
		/*
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		actions.add(new NodeCusUpdateL1(option).toAction());	
		actions.add(new RootCusSelect(option).toAction());
		return actions;
		*/
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
	
	
	
	@Override public ActionStd<CusInfo> toAction() {
		return tree.toAction();
	}
}
