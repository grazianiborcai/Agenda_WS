package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.StdCusDelete;
import br.com.gda.business.customer.model.action.StdCusDeletePerson;
import br.com.gda.business.customer.model.checker.CusCheckExist;
import br.com.gda.business.customer.model.checker.CusCheckPersonChange;
import br.com.gda.business.customer.model.checker.CusCheckWrite;
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

public final class RootCusDelete implements DeciTree<CusInfo> {
	private DeciTree<CusInfo> tree;
	
	
	public RootCusDelete(DeciTreeOption<CusInfo> option) {
		DeciTreeHelperOption<CusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CusInfo> buildDecisionChecker(DeciTreeOption<CusInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean NOT_CHANGED = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new CusCheckWrite();
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
		checker = new CusCheckPersonChange(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<CusInfo>(queue);
	}
	
	
	
	@Override public ActionStd<CusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<CusInfo>> buildActionsOnPassed(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> deleteAddress = new NodeCusDeleteAddress(option).toAction();
		ActionStd<CusInfo> deletePhone = new NodeCusDeletePhone(option).toAction();
		ActionStd<CusInfo> deleteCustomer = new StdCusDelete(option);	
		ActionStd<CusInfo> deletePerson = new StdCusDeletePerson(option);
		
		actions.add(deleteAddress);
		actions.add(deletePhone);
		actions.add(deleteCustomer);
		actions.add(deletePerson);
		
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
