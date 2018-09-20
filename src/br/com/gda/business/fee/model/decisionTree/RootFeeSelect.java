package br.com.gda.business.fee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.fee.info.FeeInfo;
import br.com.gda.business.fee.model.checker.FeeCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootFeeSelect implements DeciTree<FeeInfo> {
	private DeciTree<FeeInfo> tree;
	
	
	public RootFeeSelect(DeciTreeOption<FeeInfo> option) {
		DeciTreeHelperOption<FeeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeeInfo> buildDecisionChecker() {
		List<ModelChecker<FeeInfo>> queue = new ArrayList<>();		
		ModelChecker<FeeInfo> checker;
		
		checker = new FeeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<FeeInfo>> buildActionsOnPassed(DeciTreeOption<FeeInfo> option) {
		List<DeciAction<FeeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionFeeSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<FeeInfo> toAction() {
		return tree.toAction();
	}
}
