package br.com.gda.business.employeePosition.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeePosition.info.EmposInfo;
import br.com.gda.business.employeePosition.model.action.StdEmposInsert;
import br.com.gda.business.employeePosition.model.action.StdEmposUpdate;
import br.com.gda.business.employeePosition.model.checker.EmposCheckSoftDelete;
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

public final class NodeEmposInsert implements DeciTree<EmposInfo> {
	private DeciTree<EmposInfo> tree;
	
	
	public NodeEmposInsert(DeciTreeOption<EmposInfo> option) {
		DeciTreeHelperOption<EmposInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmposInfo> buildDecisionChecker(DeciTreeOption<EmposInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<EmposInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new EmposCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmposInfo>> buildActionsOnPassed(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmposInsert(option));
		return actions;
	}
	
	
	
	private List<ActionStd<EmposInfo>> buildActionsOnFailed(DeciTreeOption<EmposInfo> option) {
		List<ActionStd<EmposInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmposUpdate(option));	
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
