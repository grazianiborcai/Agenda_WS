package br.com.gda.payService.payCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

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
import br.com.gda.payService.payCustomer.model.action.StdPayCusDelete;
import br.com.gda.payService.payCustomer.model.action.StdPayCusDeletePerson;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckExist;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckPersonChange;
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
		checker = new PayCusCheckExist(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = NOT_CHANGED;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new PayCusCheckPersonChange(checkerOption);
		queue.add(checker);
		
		 return new ModelCheckerQueue<PayCusInfo>(queue);
	}
	
	
	
	@Override public ActionStd<PayCusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PayCusInfo>> buildActionsOnPassed(DeciTreeOption<PayCusInfo> option) {
		List<ActionStd<PayCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PayCusInfo> deleteAddress = new NodePayCusDeleteAddress(option).toAction();
		ActionStd<PayCusInfo> deletePhone = new NodePayCusDeletePhone(option).toAction();
		ActionStd<PayCusInfo> deleteCustomer = new StdPayCusDelete(option);	
		ActionStd<PayCusInfo> deletePerson = new StdPayCusDeletePerson(option);
		
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
	
	
	
	@Override public DeciResult<PayCusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
