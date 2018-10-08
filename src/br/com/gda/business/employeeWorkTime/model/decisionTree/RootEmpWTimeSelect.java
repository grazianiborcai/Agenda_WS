package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpWTimeSelect implements DeciTree<EmpWTimeInfo> {
	private DeciTree<EmpWTimeInfo> tree;
	
	
	public RootEmpWTimeSelect(DeciTreeOption<EmpWTimeInfo> option) {
		DeciTreeHelperOption<EmpWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker() {
		List<ModelChecker<EmpWTimeInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		checker = new EmpWTimeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<EmpWTimeInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<EmpWTimeInfo>> buildActionsOnPassed(DeciTreeOption<EmpWTimeInfo> option) {
		List<ActionStd<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpWTimeSelect(option));
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
