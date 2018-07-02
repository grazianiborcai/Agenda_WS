package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.checker.GenderCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootGenderSelect implements DeciTree<GenderInfo> {
	private DeciTree<GenderInfo> tree;
	
	
	public RootGenderSelect(DeciTreeOption<GenderInfo> option) {
		DeciTreeHelperOption<GenderInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<GenderInfo> buildDecisionChecker() {
		List<ModelChecker<GenderInfo>> queue = new ArrayList<>();		
		ModelChecker<GenderInfo> checker;
		
		checker = new GenderCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<GenderInfo>> buildActionsOnPassed(DeciTreeOption<GenderInfo> option) {
		List<DeciAction<GenderInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionGenderSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<GenderInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<GenderInfo> toAction() {
		return tree.toAction();
	}
}
