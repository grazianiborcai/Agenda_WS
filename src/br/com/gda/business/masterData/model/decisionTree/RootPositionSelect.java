package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.business.masterData.model.action.StdPositionSelect;
import br.com.gda.business.masterData.model.checker.PositionCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootPositionSelect implements DeciTree<PositionInfo> {
	private DeciTree<PositionInfo> tree;
	
	
	public RootPositionSelect(DeciTreeOption<PositionInfo> option) {
		DeciTreeHelperOption<PositionInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PositionInfo> buildDecisionChecker() {
		List<ModelChecker<PositionInfo>> queue = new ArrayList<>();		
		ModelChecker<PositionInfo> checker;
		
		checker = new PositionCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PositionInfo>> buildActionsOnPassed(DeciTreeOption<PositionInfo> option) {
		List<ActionStd<PositionInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPositionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PositionInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PositionInfo> toAction() {
		return tree.toAction();
	}
}
