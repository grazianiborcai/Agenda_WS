package br.com.gda.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.action.LazyEmposDeleteEWT;
import br.com.gda.business.employeePosition.model.action.StdEmposSuccess;
import br.com.gda.business.employeePosition.model.checker.EmposCheckEWT;
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

final class NodeEmposDeleteEWT implements DeciTree<EmposInfo> {
	private DeciTree<EmposInfo> tree;
	
	
	public NodeEmposDeleteEWT(DeciTreeOption<EmposInfo> option) {
		DeciTreeHelperOption<EmposInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmposInfo> buildDecisionChecker(DeciTreeOption<EmposInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmposCheckEWT(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmposInfo>> buildActionsOnPassed(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();		
		actions.add(new LazyEmposDeleteEWT(option.conn, option.schemaName).toAction(option.recordInfos));
		return actions;
	}
	
	
	
	private List<ActionStd<EmposInfo>> buildActionsOnFailed(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();		
		actions.add(new StdEmposSuccess(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmposInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<EmposInfo> toAction() {
		return tree.toAction();
	}
}
