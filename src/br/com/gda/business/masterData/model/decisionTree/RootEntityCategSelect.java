package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.EntityCategInfo;
import br.com.gda.business.masterData.model.action.StdEntityCategSelect;
import br.com.gda.business.masterData.model.checker.EntityCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEntityCategSelect implements DeciTree<EntityCategInfo> {
	private DeciTree<EntityCategInfo> tree;
	
	
	public RootEntityCategSelect(DeciTreeOption<EntityCategInfo> option) {
		DeciTreeHelperOption<EntityCategInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EntityCategInfo> buildDecisionChecker() {
		List<ModelChecker<EntityCategInfo>> queue = new ArrayList<>();		
		ModelChecker<EntityCategInfo> checker;
		
		checker = new EntityCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<EntityCategInfo>> buildActionsOnPassed(DeciTreeOption<EntityCategInfo> option) {
		List<ActionStd<EntityCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEntityCategSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EntityCategInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<EntityCategInfo> toAction() {
		return tree.toAction();
	}
}
