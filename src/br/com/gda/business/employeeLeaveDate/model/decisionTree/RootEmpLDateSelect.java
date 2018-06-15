package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public class RootEmpLDateSelect implements DeciTree<EmpLDateInfo> {
	private DeciTree<EmpLDateInfo> tree;
	
	
	public RootEmpLDateSelect(DeciTreeOption<EmpLDateInfo> option) {
		DeciTreeHelperOption<EmpLDateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpLDateInfo> buildDecisionChecker() {
		List<ModelChecker<EmpLDateInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpLDateInfo> checker;
		
		checker = new EmpLDateCheckRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	@Override public DeciAction<EmpLDateInfo> getAsAction() {
		return tree.getAsAction();
	}
	
	
	
	private List<DeciAction<EmpLDateInfo>> buildActionsOnPassed(DeciTreeOption<EmpLDateInfo> option) {
		List<DeciAction<EmpLDateInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpLDateSelect(option));
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
}
