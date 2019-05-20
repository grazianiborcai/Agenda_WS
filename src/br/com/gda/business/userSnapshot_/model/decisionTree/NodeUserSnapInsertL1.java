package br.com.gda.business.userSnapshot_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.business.userSnapshot_.model.action.LazyUserSnapNodeInsertL2;
import br.com.gda.business.userSnapshot_.model.action.StdUserSnapMergeSnap;
import br.com.gda.business.userSnapshot_.model.checker.UserSnapCheckHasSnap;
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

public final class NodeUserSnapInsertL1 implements DeciTree<UserSnapInfo> {
	private DeciTree<UserSnapInfo> tree;
	
	
	public NodeUserSnapInsertL1(DeciTreeOption<UserSnapInfo> option) {
		DeciTreeHelperOption<UserSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserSnapInfo> buildDecisionChecker(DeciTreeOption<UserSnapInfo> option) {
		List<ModelChecker<UserSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserSnapInfo> checker;	
		
		checker = new UserSnapCheckHasSnap();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserSnapInfo>> buildActionsOnPassed(DeciTreeOption<UserSnapInfo> option) {
		List<ActionStd<UserSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserSnapInfo> nodeL2 = new NodeUserSnapInsertL2(option).toAction();	
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	private List<ActionStd<UserSnapInfo>> buildActionsOnFailed(DeciTreeOption<UserSnapInfo> option) {
		List<ActionStd<UserSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserSnapInfo> mergeSnap = new StdUserSnapMergeSnap(option);	
		ActionLazy<UserSnapInfo> nodeL2 = new LazyUserSnapNodeInsertL2(option.conn, option.schemaName);	
		
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
	
	
	
	@Override public DeciResult<UserSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<UserSnapInfo> toAction() {
		return tree.toAction();
	}
}
