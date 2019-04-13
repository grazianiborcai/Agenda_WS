package br.com.gda.business.employeeMaterial.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeMaterial.model.action.StdEmpmatInsert;
import br.com.gda.business.employeeMaterial.model.action.StdEmpmatSelectAll_;
import br.com.gda.business.employeeMaterial.model.action.StdEmpmatUpdate;
import br.com.gda.business.employeeMaterial.model.chekcer.EmpmatCheckSoftDelete;
import br.com.gda.business.employeeMaterial.model.chekcer.EmpmatCheckWrite;
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

final class NodeEmpmatInsert implements DeciTree<EmpmatInfo> {
	private DeciTree<EmpmatInfo> tree;
	
	
	public NodeEmpmatInsert(DeciTreeOption<EmpmatInfo> option) {
		DeciTreeHelperOption<EmpmatInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpmatInfo> buildDecisionChecker(DeciTreeOption<EmpmatInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<EmpmatInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpmatInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpmatCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new EmpmatCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmpmatInfo>> buildActionsOnPassed(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpmatInsert(option));
		actions.add(new StdEmpmatSelectAll_(option));
		return actions;
	}
	
	
	
	private List<ActionStd<EmpmatInfo>> buildActionsOnFailed(DeciTreeOption<EmpmatInfo> option) {
		List<ActionStd<EmpmatInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpmatUpdate(option));
		actions.add(new StdEmpmatSelectAll_(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpmatInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<EmpmatInfo> toAction() {
		return tree.toAction();
	}
}
