package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.business.employee.model.checker.EmpWtimeCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpWtimeSelect implements DeciTree<EmpWTimeInfo> {
	private DeciTree<EmpWTimeInfo> tree;
	
	
	public RootEmpWtimeSelect(DeciTreeOption<EmpWTimeInfo> option) {
		DeciTreeHelperOption<EmpWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker() {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		checker = new EmpWtimeCheckRead();
		stack.add(checker);
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<EmpWTimeInfo>> buildActionsOnPassed(DeciTreeOption<EmpWTimeInfo> option) {
		List<DeciAction<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpWtimeSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
