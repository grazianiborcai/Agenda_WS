package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.business.masterData.model.action.StdAreaPhoneSelect;
import br.com.gda.business.masterData.model.checker.AreaPhoneCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAreaPhoneSelect implements DeciTree<AreaPhoneInfo> {
	private DeciTree<AreaPhoneInfo> tree;
	
	
	public RootAreaPhoneSelect(DeciTreeOption<AreaPhoneInfo> option) {
		DeciTreeHelperOption<AreaPhoneInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<AreaPhoneInfo> buildDecisionChecker() {
		List<ModelChecker<AreaPhoneInfo>> queue = new ArrayList<>();		
		ModelChecker<AreaPhoneInfo> checker;
		
		checker = new AreaPhoneCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	private List<ActionStd<AreaPhoneInfo>> buildActionsOnPassed(DeciTreeOption<AreaPhoneInfo> option) {
		List<ActionStd<AreaPhoneInfo>> actions = new ArrayList<>();
		
		actions.add(new StdAreaPhoneSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<AreaPhoneInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<AreaPhoneInfo> toAction() {
		return tree.toAction();
	}
}
