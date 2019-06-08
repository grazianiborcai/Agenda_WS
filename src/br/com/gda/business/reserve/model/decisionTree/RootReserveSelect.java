package br.com.gda.business.reserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.business.reserve.model.action.StdReserveSelect;
import br.com.gda.business.reserve.model.checker.ReserveCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootReserveSelect implements DeciTree<ReserveInfo> {
	private DeciTree<ReserveInfo> tree;
	
	
	public RootReserveSelect(DeciTreeOption<ReserveInfo> option) {
		DeciTreeHelperOption<ReserveInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<ReserveInfo> buildDecisionChecker(DeciTreeOption<ReserveInfo> option) {
		List<ModelChecker<ReserveInfo>> queue = new ArrayList<>();		
		ModelChecker<ReserveInfo> checker;	
		
		checker = new ReserveCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<ReserveInfo>> buildActionsOnPassed(DeciTreeOption<ReserveInfo> option) {
		List<ActionStd<ReserveInfo>> actions = new ArrayList<>();	
		
		actions.add(new StdReserveSelect(option));			
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<ReserveInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<ReserveInfo> toAction() {
		return tree.toAction();
	}
}
