package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.model.checker.MatGroupCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatGroupSelect implements DeciTree<MatGroupInfo> {
	private DeciTree<MatGroupInfo> tree;
	
	
	public RootMatGroupSelect(DeciTreeOption<MatGroupInfo> option) {
		DeciTreeHelperOption<MatGroupInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatGroupInfo> buildDecisionChecker() {
		List<ModelChecker<MatGroupInfo>> queue = new ArrayList<>();		
		ModelChecker<MatGroupInfo> checker;
		
		checker = new MatGroupCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatGroupInfo>> buildActionsOnPassed(DeciTreeOption<MatGroupInfo> option) {
		List<ActionStd<MatGroupInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatGroupSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatGroupInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatGroupInfo> toAction() {
		return tree.toAction();
	}
}
