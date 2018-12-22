package br.com.gda.business.materialSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.checker.MatSnapCheckMat;
import br.com.gda.business.materialSnapshot.model.checker.MatSnapCheckOwner;
import br.com.gda.business.materialSnapshot.model.checker.MatSnapCheckWrite;
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

public final class RootMatSnapInsert implements DeciTree<MatSnapInfo> {
	private DeciTree<MatSnapInfo> tree;
	
	
	public RootMatSnapInsert(DeciTreeOption<MatSnapInfo> option) {
		DeciTreeHelperOption<MatSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatSnapInfo> buildDecisionChecker(DeciTreeOption<MatSnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<MatSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new MatSnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new MatSnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new MatSnapCheckMat(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatSnapInfo>> buildActionsOnPassed(DeciTreeOption<MatSnapInfo> option) {
		List<ActionStd<MatSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<MatSnapInfo> nodeInsert = new NodeMatSnapInsertL1(option).toAction();
		actions.add(nodeInsert);		
		
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
