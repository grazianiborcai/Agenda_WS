package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.action.LazyEmpUpsertAddress;
import br.com.gda.business.employee.model.action.StdEmpEnforceAddressKey;
import br.com.gda.business.employee.model.action.StdEmpSuccess;
import br.com.gda.business.employee.model.checker.EmpCheckHasAddress;
import br.com.gda.model.action.ActionLazy;
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

public final class NodeEmpUpsertAddress implements DeciTree<EmpInfo> {
	private DeciTree<EmpInfo> tree;
	
	
	public NodeEmpUpsertAddress(DeciTreeOption<EmpInfo> option) {
		DeciTreeHelperOption<EmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DeciTreeOption<EmpInfo> option) {
		final boolean HAS_ADDRESS = true;
		
		List<ModelChecker<EmpInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_ADDRESS;		
		checker = new EmpCheckHasAddress(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<EmpInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<EmpInfo>> buildActionsOnPassed(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		ActionStd<EmpInfo> enforceAddressKey = new StdEmpEnforceAddressKey(option);
		ActionLazy<EmpInfo> upsertAddress = new LazyEmpUpsertAddress(option.conn, option.schemaName);
		
		enforceAddressKey.addPostAction(upsertAddress);
		
		actions.add(enforceAddressKey);		
		return actions;
	}
	
	
	
	private List<ActionStd<EmpInfo>> buildActionsOnFailed(DeciTreeOption<EmpInfo> option) {
		List<ActionStd<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpSuccess(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
