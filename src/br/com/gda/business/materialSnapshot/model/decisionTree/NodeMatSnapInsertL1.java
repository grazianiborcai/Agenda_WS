package br.com.gda.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapNodeInsertL2;
import br.com.gda.business.materialSnapshot.model.action.StdMatSnapMergeSnap;
import br.com.gda.business.materialSnapshot.model.checker.MatSnapCheckHasSnap;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeMatSnapInsertL1 implements DeciTree<MatSnapInfo> {
	private DeciTree<MatSnapInfo> tree;
	
	
	public NodeMatSnapInsertL1(DeciTreeOption<MatSnapInfo> option) {
		DeciTreeHelperOption<MatSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatSnapInfo> buildDecisionChecker(DeciTreeOption<MatSnapInfo> option) {
		List<ModelChecker<MatSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatSnapInfo> checker;	
		
		checker = new MatSnapCheckHasSnap();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatSnapInfo>> buildActionsOnPassed(DeciTreeOption<MatSnapInfo> option) {
		List<ActionStd<MatSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<MatSnapInfo> nodeL2 = new NodeMatSnapInsertL2(option).toAction();	
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	private List<ActionStd<MatSnapInfo>> buildActionsOnFailed(DeciTreeOption<MatSnapInfo> option) {
		List<ActionStd<MatSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<MatSnapInfo> mergeSnap = new StdMatSnapMergeSnap(option);	
		ActionLazy<MatSnapInfo> nodeL2 = new LazyMatSnapNodeInsertL2(option.conn, option.schemaName);	
		
		mergeSnap.addPostAction(nodeL2);
		
		actions.add(mergeSnap);
		return actions;
	}	
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatSnapInfo> toAction() {
		return tree.toAction();
	}
}
