package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateInsert;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateUpdate;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckSoftDelete;
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

public final class NodeEmplevateInsert implements DeciTree<EmplevateInfo> {
	private DeciTree<EmplevateInfo> tree;
	
	
	public NodeEmplevateInsert(DeciTreeOption<EmplevateInfo> option) {
		DeciTreeHelperOption<EmplevateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmplevateInfo> buildDecisionChecker(DeciTreeOption<EmplevateInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<EmplevateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplevateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new EmplevateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmplevateInfo>> buildActionsOnPassed(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmplevateInsert(option));				
		return actions;
	}
	
	
	
	private List<ActionStd<EmplevateInfo>> buildActionsOnFailed(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmplevateUpdate(option));	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmplevateInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<EmplevateInfo> toAction() {
		return tree.toAction();
	}
}
