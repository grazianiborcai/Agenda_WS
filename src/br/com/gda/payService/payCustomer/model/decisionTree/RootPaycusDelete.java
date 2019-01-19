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
import br.com.gda.payService.payCustomer.model.action.LazyPaycusDelete;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusDeletePerson;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusNodeDeleteAddress;
import br.com.gda.payService.payCustomer.model.action.LazyPaycusNodeDeletePhone;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckUserTaken;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckWrite;

public final class RootPaycusDelete implements DeciTree<PaycusInfo> {
	private DeciTree<PaycusInfo> tree;
	
	
	public RootPaycusDelete(DeciTreeOption<PaycusInfo> option) {
		DeciTreeHelperOption<PaycusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PaycusInfo> buildDecisionChecker(DeciTreeOption<PaycusInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<PaycusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaycusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PaycusCheckWrite();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PaycusCheckUserTaken(checkerOption);
		queue.add(checker);	
		
		 return new ModelCheckerQueue<PaycusInfo>(queue);
	}
	
	
	
	@Override public ActionStd<PaycusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PaycusInfo>> buildActionsOnPassed(DeciTreeOption<PaycusInfo> option) {
		List<ActionStd<PaycusInfo>> actions = new ArrayList<>();
		
		ActionStd<PaycusInfo> select = new RootPaycusSelect(option).toAction();
		ActionLazy<PaycusInfo> deleteAddress = new LazyPaycusNodeDeleteAddress(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> deletePhone = new LazyPaycusNodeDeletePhone(option.conn, option.schemaName);
		ActionLazy<PaycusInfo> deletePayCustomer = new LazyPaycusDelete(option.conn, option.schemaName);	
		ActionLazy<PaycusInfo> deletePerson = new LazyPaycusDeletePerson(option.conn, option.schemaName);
		
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
	
	
	
	@Override public DeciResult<PaycusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
