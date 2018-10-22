package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.business.masterData.model.action.StdCartCategSelect;
import br.com.gda.business.masterData.model.checker.CartCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCartCategSelect implements DeciTree<CartCategInfo> {
	private DeciTree<CartCategInfo> tree;
	
	
	public RootCartCategSelect(DeciTreeOption<CartCategInfo> option) {
		DeciTreeHelperOption<CartCategInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CartCategInfo> buildDecisionChecker() {
		List<ModelChecker<CartCategInfo>> queue = new ArrayList<>();		
		ModelChecker<CartCategInfo> checker;
		
		checker = new CartCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<CartCategInfo>> buildActionsOnPassed(DeciTreeOption<CartCategInfo> option) {
		List<ActionStd<CartCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCartCategSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CartCategInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<CartCategInfo> toAction() {
		return tree.toAction();
	}
}
