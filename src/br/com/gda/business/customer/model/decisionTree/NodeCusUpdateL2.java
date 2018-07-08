package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.checker.CusCheckExistCpf;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class NodeCusUpdateL2 implements DeciTree<CusInfo> {
	private DeciTree<CusInfo> tree;
	
	
	public NodeCusUpdateL2(DeciTreeOption<CusInfo> option) {
		DeciTreeHelperOption<CusInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.schemaName = option.schemaName;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<CusInfo> buildDecisionChecker(DeciTreeOption<CusInfo> option) {		
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckExistCpf(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<CusInfo>> buildActionsOnPassed(DeciTreeOption<CusInfo> option) {
		List<DeciAction<CusInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionCusUpdate(option));
		actions.add(new ActionCusSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<CusInfo> toAction() {
		return tree.toAction();
	}
}
