package br.com.gda.business.snapshot_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.business.snapshot_.model.action.StdSnapSelect;
import br.com.gda.business.snapshot_.model.checker.SnapCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootSnapSelect implements DeciTree<SnapInfo> {
	private DeciTree<SnapInfo> tree;
	
	
	public RootSnapSelect(DeciTreeOption<SnapInfo> option) {
		DeciTreeHelperOption<SnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<SnapInfo> buildDecisionChecker(DeciTreeOption<SnapInfo> option) {
		List<ModelChecker<SnapInfo>> queue = new ArrayList<>();		
		ModelChecker<SnapInfo> checker;	
		
		checker = new SnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<SnapInfo>> buildActionsOnPassed(DeciTreeOption<SnapInfo> option) {
		List<ActionStd<SnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<SnapInfo> select = new StdSnapSelect(option);		
		actions.add(select);	
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<SnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<SnapInfo> toAction() {
		return tree.toAction();
	}
}
