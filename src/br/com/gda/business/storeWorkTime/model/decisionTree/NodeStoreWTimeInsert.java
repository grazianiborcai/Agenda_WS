package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.business.storeWorkTime.model.checker.StoreWTimeCheckSoftDelete;
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

public final class NodeStoreWTimeInsert implements DeciTree<StoreWTimeInfo> {
	private DeciTree<StoreWTimeInfo> tree;
	
	
	public NodeStoreWTimeInsert(DeciTreeOption<StoreWTimeInfo> option) {
		DeciTreeHelperOption<StoreWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreWTimeInfo> buildDecisionChecker(DeciTreeOption<StoreWTimeInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<StoreWTimeInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreWTimeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StoreWTimeCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<StoreWTimeInfo>> buildActionsOnPassed(DeciTreeOption<StoreWTimeInfo> option) {
		List<DeciAction<StoreWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionStoreWTimeInsert(option));				
		return actions;
	}
	
	
	
	private List<DeciAction<StoreWTimeInfo>> buildActionsOnFailed(DeciTreeOption<StoreWTimeInfo> option) {
		List<DeciAction<StoreWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionStoreWTimeUpdate(option));	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<StoreWTimeInfo> toAction() {
		return tree.toAction();
	}
}
