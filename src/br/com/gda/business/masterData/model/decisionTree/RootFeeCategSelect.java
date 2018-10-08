package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.model.checker.FeeCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootFeeCategSelect implements DeciTree<FeeCategInfo> {
	private DeciTree<FeeCategInfo> tree;
	
	
	public RootFeeCategSelect(DeciTreeOption<FeeCategInfo> option) {
		DeciTreeHelperOption<FeeCategInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeeCategInfo> buildDecisionChecker() {
		List<ModelChecker<FeeCategInfo>> queue = new ArrayList<>();		
		ModelChecker<FeeCategInfo> checker;
		
		checker = new FeeCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<FeeCategInfo>> buildActionsOnPassed(DeciTreeOption<FeeCategInfo> option) {
		List<ActionStd<FeeCategInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionFeeCategSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeeCategInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeeCategInfo> toAction() {
		return tree.toAction();
	}
}
