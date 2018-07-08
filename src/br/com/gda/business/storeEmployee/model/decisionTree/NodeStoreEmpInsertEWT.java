package br.com.gda.business.storeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckSWT;
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

final class NodeStoreEmpInsertEWT implements DeciTree<StoreEmpInfo> {
	private DeciTree<StoreEmpInfo> tree;
	
	
	public NodeStoreEmpInsertEWT(DeciTreeOption<StoreEmpInfo> option) {
		DeciTreeHelperOption<StoreEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DeciTreeOption<StoreEmpInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<StoreEmpInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreEmpCheckSWT(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<StoreEmpInfo>> buildActionsOnPassed(DeciTreeOption<StoreEmpInfo> option) {
		List<DeciAction<StoreEmpInfo>> actions = new ArrayList<>();		
		actions.add(new HandlerStoreEmpInsertEWT(option.conn, option.schemaName).toAction(option.recordInfos));
		return actions;
	}
	
	
	
	private List<DeciAction<StoreEmpInfo>> buildActionsOnFailed(DeciTreeOption<StoreEmpInfo> option) {
		List<DeciAction<StoreEmpInfo>> actions = new ArrayList<>();		
		actions.add(new ActionStoreEmpSuccess(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<StoreEmpInfo> toAction() {
		return tree.toAction();
	}
}
