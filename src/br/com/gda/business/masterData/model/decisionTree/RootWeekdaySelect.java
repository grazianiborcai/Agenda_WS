package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.masterData.model.checker.WeekdayCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootWeekdaySelect implements DeciTree<WeekdayInfo> {
	private DeciTree<WeekdayInfo> tree;
	
	
	public RootWeekdaySelect(DeciTreeOption<WeekdayInfo> option) {
		DeciTreeHelperOption<WeekdayInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<WeekdayInfo> buildDecisionChecker() {
		List<ModelChecker<WeekdayInfo>> stack = new ArrayList<>();		
		ModelChecker<WeekdayInfo> checker;
		
		checker = new WeekdayCheckRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}

		
	
	private List<DeciAction<WeekdayInfo>> buildActionsOnPassed(DeciTreeOption<WeekdayInfo> option) {
		List<DeciAction<WeekdayInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionWeekdaySelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<WeekdayInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<WeekdayInfo> getAsAction() {
		return tree.getAsAction();
	}
}
