package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckSoftDelete;
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

final class NodeEmpLDateInsert implements DeciTree<EmpLDateInfo> {
	private DeciTree<EmpLDateInfo> tree;
	
	
	public NodeEmpLDateInsert(DeciTreeOption<EmpLDateInfo> option) {
		DeciTreeHelperOption<EmpLDateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpLDateInfo> buildDecisionChecker(DeciTreeOption<EmpLDateInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<EmpLDateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpLDateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new EmpLDateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<EmpLDateInfo>> buildActionsOnPassed(DeciTreeOption<EmpLDateInfo> option) {
		List<DeciAction<EmpLDateInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpLDateInsert(option));				
		return actions;
	}
	
	
	
	private List<DeciAction<EmpLDateInfo>> buildActionsOnFailed(DeciTreeOption<EmpLDateInfo> option) {
		List<DeciAction<EmpLDateInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpLDateUpdate(option));	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpLDateInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<EmpLDateInfo> toAction() {
		return tree.toAction();
	}
}
