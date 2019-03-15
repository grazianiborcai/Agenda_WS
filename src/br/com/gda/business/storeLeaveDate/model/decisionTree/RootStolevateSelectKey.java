package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateSelectKey;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootStolevateSelectKey implements DeciTree<StolevateInfo> {
	private DeciTree<StolevateInfo> tree;
	
	
	public RootStolevateSelectKey(DeciTreeOption<StolevateInfo> option) {
		DeciTreeHelperOption<StolevateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StolevateInfo> buildDecisionChecker() {
		List<ModelChecker<StolevateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolevateInfo> checker;
		
		checker = new StolevateCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StolevateInfo>> buildActionsOnPassed(DeciTreeOption<StolevateInfo> option) {
		List<ActionStd<StolevateInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStolevateSelectKey(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StolevateInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StolevateInfo> toAction() {
		return tree.toAction();
	}
}
