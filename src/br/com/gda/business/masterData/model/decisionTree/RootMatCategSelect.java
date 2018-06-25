package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.model.checker.MatCategCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatCategSelect implements DeciTree<MatCategInfo> {
	private DeciTree<MatCategInfo> tree;
	
	
	public RootMatCategSelect(DeciTreeOption<MatCategInfo> option) {
		DeciTreeHelperOption<MatCategInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatCategInfo> buildDecisionChecker() {
		List<ModelChecker<MatCategInfo>> stack = new ArrayList<>();		
		ModelChecker<MatCategInfo> checker;
		
		checker = new MatCategCheckRead();
		stack.add(checker);
		
		return new ModelCheckerQueue<>(stack);
	}
	
	
	
	private List<DeciAction<MatCategInfo>> buildActionsOnPassed(DeciTreeOption<MatCategInfo> option) {
		List<DeciAction<MatCategInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatCategSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatCategInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<MatCategInfo> toAction() {
		return tree.toAction();
	}
}
