package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.business.storeLeaveDate.model.checker.StoreLDateCheckSoftDelete;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class NodeStoreLDateInsert implements DeciTree<StoreLDateInfo> {
	private DeciTree<StoreLDateInfo> tree;
	
	
	public NodeStoreLDateInsert(DeciTreeOption<StoreLDateInfo> option) {
		DeciTreeHelperOption<StoreLDateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreLDateInfo> buildDecisionChecker(DeciTreeOption<StoreLDateInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<StoreLDateInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreLDateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StoreLDateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<StoreLDateInfo>> buildActionsOnPassed(DeciTreeOption<StoreLDateInfo> option) {
		List<DeciAction<StoreLDateInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionStoreLDateInsert(option));				
		return actions;
	}
	
	
	
	private List<DeciAction<StoreLDateInfo>> buildActionsOnFailed(DeciTreeOption<StoreLDateInfo> option) {
		List<DeciAction<StoreLDateInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionStoreLDateUpdate(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreLDateInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<StoreLDateInfo> toAction() {
		return tree.toAction();
	}
}
