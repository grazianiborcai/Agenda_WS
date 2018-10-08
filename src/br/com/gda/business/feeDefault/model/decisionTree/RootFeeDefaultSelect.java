package br.com.gda.business.feeDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeDefault.model.checker.FeeDefaultCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootFeeDefaultSelect implements DeciTree<FeeDefaultInfo> {
	private DeciTree<FeeDefaultInfo> tree;
	
	
	public RootFeeDefaultSelect(DeciTreeOption<FeeDefaultInfo> option) {
		DeciTreeHelperOption<FeeDefaultInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeeDefaultInfo> buildDecisionChecker() {
		List<ModelChecker<FeeDefaultInfo>> queue = new ArrayList<>();		
		ModelChecker<FeeDefaultInfo> checker;
		
		checker = new FeeDefaultCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FeeDefaultInfo>> buildActionsOnPassed(DeciTreeOption<FeeDefaultInfo> option) {
		List<ActionStd<FeeDefaultInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionFeeDefaultSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeeDefaultInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeeDefaultInfo> toAction() {
		return tree.toAction();
	}
}
