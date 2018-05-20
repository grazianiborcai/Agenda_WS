package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.checker.ModelCherckerTrue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LanguRootSelect implements DeciTree<LanguInfo> {
	private DeciTree<LanguInfo> tree;
	
	
	public LanguRootSelect(DeciTreeOption<LanguInfo> option) {
		DeciTreeHelperOption<LanguInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<LanguInfo> buildDecisionChecker() {
		List<ModelChecker<LanguInfo>> stack = new ArrayList<>();		
		ModelChecker<LanguInfo> checker;
		
		checker = new ModelCherckerTrue<>();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<LanguInfo>> buildActionsOnPassed(DeciTreeOption<LanguInfo> option) {
		List<DeciAction<LanguInfo>> actions = new ArrayList<>();
		
		actions.add(new LanguActionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<LanguInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
