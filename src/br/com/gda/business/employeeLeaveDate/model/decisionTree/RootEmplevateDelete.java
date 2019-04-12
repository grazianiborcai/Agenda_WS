package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateDelete;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckExist;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckKey;
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

public final class RootEmplevateDelete implements DeciTree<EmplevateInfo> {
	private DeciTree<EmplevateInfo> tree;
	
	
	public RootEmplevateDelete(DeciTreeOption<EmplevateInfo> option) {
		DeciTreeHelperOption<EmplevateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmplevateInfo> buildDecisionChecker(DeciTreeOption<EmplevateInfo> option) {
		List<ModelChecker<EmplevateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplevateInfo> checker;
		
		checker = new EmplevateCheckKey();
		queue.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;
		
		checker = new EmplevateCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerQueue<EmplevateInfo>(queue);
	}
	
	
	
	@Override public ActionStd<EmplevateInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<EmplevateInfo>> buildActionsOnPassed(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmplevateDelete(option));
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
}
