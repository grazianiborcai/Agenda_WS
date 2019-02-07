package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.UserCategInfo;
import br.com.gda.business.masterData.model.action.StdUserCategSelect;
import br.com.gda.business.masterData.model.checker.UserCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootUserCategSelect implements DeciTree<UserCategInfo> {
	private DeciTree<UserCategInfo> tree;
	
	
	public RootUserCategSelect(DeciTreeOption<UserCategInfo> option) {
		DeciTreeHelperOption<UserCategInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserCategInfo> buildDecisionChecker() {
		List<ModelChecker<UserCategInfo>> queue = new ArrayList<>();		
		ModelChecker<UserCategInfo> checker;
		
		checker = new UserCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserCategInfo>> buildActionsOnPassed(DeciTreeOption<UserCategInfo> option) {
		List<ActionStd<UserCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdUserCategSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UserCategInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<UserCategInfo> toAction() {
		return tree.toAction();
	}
}
