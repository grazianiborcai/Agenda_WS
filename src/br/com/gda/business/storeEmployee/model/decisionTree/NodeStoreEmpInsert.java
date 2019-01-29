package br.com.gda.business.storeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.business.storeEmployee.model.action.StdStoreEmpInsert;
import br.com.gda.business.storeEmployee.model.action.StdStoreEmpUpdate;
import br.com.gda.business.storeEmployee.model.checker.StoreEmpCheckSoftDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class NodeStoreEmpInsert implements DeciTree<StoreEmpInfo> {
	private DeciTree<StoreEmpInfo> tree;
	
	
	public NodeStoreEmpInsert(DeciTreeOption<StoreEmpInfo> option) {
		DeciTreeHelperOption<StoreEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DeciTreeOption<StoreEmpInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<StoreEmpInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StoreEmpCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StoreEmpInfo>> buildActionsOnPassed(DeciTreeOption<StoreEmpInfo> option) {
		List<ActionStd<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoreEmpInsert(option));
		return actions;
	}
	
	
	
	private List<ActionStd<StoreEmpInfo>> buildActionsOnFailed(DeciTreeOption<StoreEmpInfo> option) {
		List<ActionStd<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoreEmpUpdate(option));	
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
	
	
	
	@Override public ActionStd<StoreEmpInfo> toAction() {
		return tree.toAction();
	}
}
