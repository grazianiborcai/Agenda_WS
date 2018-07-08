package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatStoreSelect implements DeciTree<MatStoreInfo> {
	private DeciTree<MatStoreInfo> tree;
	
	
	public RootMatStoreSelect(DeciTreeOption<MatStoreInfo> option) {
		DeciTreeHelperOption<MatStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatStoreInfo> buildDecisionChecker() {
		List<ModelChecker<MatStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatStoreInfo> checker;
		
		checker = new MatStoreCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<MatStoreInfo>> buildActionsOnPassed(DeciTreeOption<MatStoreInfo> option) {
		List<DeciAction<MatStoreInfo>> actions = new ArrayList<>();
		
		DeciAction<MatStoreInfo> starter = new ActionMatStoreSelect(option);
		starter.addPostAction(new HandlerMatStoreMergeMat(option.conn, option.schemaName));
		actions.add(starter);
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
	
	
	
	@Override public DeciAction<MatStoreInfo> toAction() {
		return tree.toAction();
	}
}
