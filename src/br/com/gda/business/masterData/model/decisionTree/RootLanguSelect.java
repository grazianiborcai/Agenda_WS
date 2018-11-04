package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.action.StdLanguSelect;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.checker.common.ModelCherckerTrue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootLanguSelect implements DeciTree<LanguInfo> {
	private DeciTree<LanguInfo> tree;
	
	
	public RootLanguSelect(DeciTreeOption<LanguInfo> option) {
		DeciTreeHelperOption<LanguInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<LanguInfo> buildDecisionChecker() {
		List<ModelChecker<LanguInfo>> queue = new ArrayList<>();		
		ModelChecker<LanguInfo> checker;
		
		checker = new ModelCherckerTrue<>();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<LanguInfo>> buildActionsOnPassed(DeciTreeOption<LanguInfo> option) {
		List<ActionStd<LanguInfo>> actions = new ArrayList<>();
		
		actions.add(new StdLanguSelect(option));
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
	
	
	
	@Override public ActionStd<LanguInfo> toAction() {
		return tree.toAction();
	}
}
