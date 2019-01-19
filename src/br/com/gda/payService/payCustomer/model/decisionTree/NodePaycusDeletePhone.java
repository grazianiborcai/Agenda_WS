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
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.model.action.StdPaycusDeletePhone;
import br.com.gda.payService.payCustomer.model.action.StdPaycusSuccess;
import br.com.gda.payService.payCustomer.model.checker.PaycusCheckHasPhone;

public final class NodePaycusDeletePhone implements DeciTree<PaycusInfo> {
	private DeciTree<PaycusInfo> tree;
	
	
	public NodePaycusDeletePhone(DeciTreeOption<PaycusInfo> option) {
		DeciTreeHelperOption<PaycusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PaycusInfo> buildDecisionChecker(DeciTreeOption<PaycusInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<PaycusInfo>> queue = new ArrayList<>();		
		ModelChecker<PaycusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;		
		checker = new PaycusCheckHasPhone(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PaycusInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PaycusInfo>> buildActionsOnPassed(DeciTreeOption<PaycusInfo> option) {
		List<ActionStd<PaycusInfo>> actions = new ArrayList<>();
		
		ActionStd<PaycusInfo> deleteAddress = new StdPaycusDeletePhone(option);
		
		actions.add(deleteAddress);		
		return actions;
	}
	
	
	
	private List<ActionStd<PaycusInfo>> buildActionsOnFailed(DeciTreeOption<PaycusInfo> option) {
		List<ActionStd<PaycusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPaycusSuccess(option));		
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
