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
import br.com.gda.payService.payCustomer.model.action.StdPayCusDeletePhone;
import br.com.gda.payService.payCustomer.model.action.StdPayCusSuccess;
import br.com.gda.payService.payCustomer.model.checker.PayCusCheckHasPhone;

public final class NodePayCusDeletePhone implements DeciTree<PayCusInfo> {
	private DeciTree<PayCusInfo> tree;
	
	
	public NodePayCusDeletePhone(DeciTreeOption<PayCusInfo> option) {
		DeciTreeHelperOption<PayCusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayCusInfo> buildDecisionChecker(DeciTreeOption<PayCusInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<PayCusInfo>> queue = new ArrayList<>();		
		ModelChecker<PayCusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;		
		checker = new PayCusCheckHasPhone(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PayCusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PayCusInfo>> buildActionsOnPassed(DeciTreeOption<PayCusInfo> option) {
		List<ActionStd<PayCusInfo>> actions = new ArrayList<>();
		
		ActionStd<PayCusInfo> deleteAddress = new StdPayCusDeletePhone(option);
		
		actions.add(deleteAddress);		
		return actions;
	}
	
	
	
	private List<ActionStd<PayCusInfo>> buildActionsOnFailed(DeciTreeOption<PayCusInfo> option) {
		List<ActionStd<PayCusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPayCusSuccess(option));		
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
