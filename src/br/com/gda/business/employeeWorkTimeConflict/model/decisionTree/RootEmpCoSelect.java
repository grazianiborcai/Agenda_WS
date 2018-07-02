package br.com.gda.business.employeeWorkTimeConflict.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.business.employeeWorkTimeConflict.model.checker.EmpCoCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpCoSelect implements DeciTree<EmpCoInfo> {
	private DeciTree<EmpCoInfo> tree;
	
	
	public RootEmpCoSelect(DeciTreeOption<EmpCoInfo> option) {
		DeciTreeHelperOption<EmpCoInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpCoInfo> buildDecisionChecker(DeciTreeOption<EmpCoInfo> option) {
		List<ModelChecker<EmpCoInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpCoInfo> checker;
		
		checker = new EmpCoCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public DeciAction<EmpCoInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<DeciAction<EmpCoInfo>> buildActionsOnPassed(DeciTreeOption<EmpCoInfo> option) {
		List<DeciAction<EmpCoInfo>> actions = new ArrayList<>();		
		actions.add(new ActionEmpCoSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpCoInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
