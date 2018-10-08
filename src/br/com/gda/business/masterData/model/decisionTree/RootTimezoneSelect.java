package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.business.masterData.model.checker.TimezoneCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootTimezoneSelect implements DeciTree<TimezoneInfo> {
	private DeciTree<TimezoneInfo> tree;
	
	
	public RootTimezoneSelect(DeciTreeOption<TimezoneInfo> option) {
		DeciTreeHelperOption<TimezoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<TimezoneInfo> buildDecisionChecker() {
		List<ModelChecker<TimezoneInfo>> queue = new ArrayList<>();		
		ModelChecker<TimezoneInfo> checker;
		
		checker = new TimezoneCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<TimezoneInfo>> buildActionsOnPassed(DeciTreeOption<TimezoneInfo> option) {
		List<ActionStd<TimezoneInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionTimezoneSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<TimezoneInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<TimezoneInfo> toAction() {
		return tree.toAction();
	}
}
