package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckSoftDelete;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckWrite;
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

final class NodeMatStoreInsert implements DeciTree<MatStoreInfo> {
	private DeciTree<MatStoreInfo> tree;
	
	
	public NodeMatStoreInsert(DeciTreeOption<MatStoreInfo> option) {
		DeciTreeHelperOption<MatStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatStoreInfo> buildDecisionChecker(DeciTreeOption<MatStoreInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<MatStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatStoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatStoreCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new MatStoreCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatStoreInfo>> buildActionsOnPassed(DeciTreeOption<MatStoreInfo> option) {
		List<ActionStd<MatStoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatStoreInsert(option));
		actions.add(new ActionMatStoreSelect(option));		
		return actions;
	}
	
	
	
	private List<ActionStd<MatStoreInfo>> buildActionsOnFailed(DeciTreeOption<MatStoreInfo> option) {
		List<ActionStd<MatStoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatStoreUpdate(option));
		actions.add(new ActionMatStoreSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatStoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatStoreInfo> toAction() {
		return tree.toAction();
	}
}
