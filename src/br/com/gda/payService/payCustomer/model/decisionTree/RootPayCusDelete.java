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
import br.com.gda.payService.payCustomer.model.action.LazyPayCusDelete;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusDeletePerson;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusNodeDeleteAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPayCusNodeDeletePhone;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckUserTaken;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckWrite;

public final class RootPayCusDelete implements DeciTree<PayCusInfo> {
	private DeciTree<PayCusInfo> tree;
	
	
	public RootPayCusDelete(DeciTreeOption<PayCusInfo> option) {
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
		
		checker = new PayCusCheckWrite();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayCusCheckUserTaken(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<PayCusInfo>(queue);
	}
	
	
	
	@Override public ActionStd<PayCusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PayCusInfo>> buildActionsOnPassed(DeciTreeOption<PayCusInfo> option) {
		List<ActionStd<PayCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PayCusInfo> select = new RootPayCusSelect(option).toAction();
		ActionLazy<PayCusInfo> deleteAddress = new LazyPayCusNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> deletePhone = new LazyPayCusNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<PayCusInfo> deletePayCustomer = new LazyPayCusDelete(option.conn, option.schemaName);	
		ActionLazy<PayCusInfo> deletePerson = new LazyPayCusDeletePerson(option.conn, option.schemaName);
		
		select.addPostAction(deleteAddress);
		select.addPostAction(deletePhone);
		select.addPostAction(deletePayCustomer);
		select.addPostAction(deletePerson);
		
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
}
