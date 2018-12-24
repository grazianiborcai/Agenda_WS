package br.com.gda.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapInsertAttr;
import br.com.gda.business.materialSnapshot.model.action.LazyMatSnapInsertText;
import br.com.gda.business.materialSnapshot.model.action.StdMatSnapMergeMat;
import br.com.gda.business.materialSnapshot.model.checker.MatSnapCheckExist;
import br.com.gda.business.materialSnapshot.model.checker.MatSnapCheckSnap;
import br.com.gda.model.action.ActionLazy;
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

public final class NodeMatSnapInsertL2 implements DeciTree<MatSnapInfo> {
	private DeciTree<MatSnapInfo> tree;
	
	
	public NodeMatSnapInsertL2(DeciTreeOption<MatSnapInfo> option) {
		DeciTreeHelperOption<MatSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatSnapInfo> buildDecisionChecker(DeciTreeOption<MatSnapInfo> option) {
		final boolean EXIST = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<MatSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new MatSnapCheckSnap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new MatSnapCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatSnapInfo>> buildActionsOnPassed(DeciTreeOption<MatSnapInfo> option) {
		List<ActionStd<MatSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<MatSnapInfo> mergeMat = new StdMatSnapMergeMat(option);
		ActionLazy<MatSnapInfo> insertAttr = new LazyMatSnapInsertAttr(option.conn, option.schemaName);	
		ActionLazy<MatSnapInfo> insertText = new LazyMatSnapInsertText(option.conn, option.schemaName);	
		
		mergeMat.addPostAction(insertAttr);
		insertAttr.addPostAction(insertText);
		
		actions.add(mergeMat);
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
