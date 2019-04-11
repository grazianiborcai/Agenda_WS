package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmInsert;
import br.com.gda.business.employeeWorkTime.model.action.StdEmpwotmUpdate;
import br.com.gda.business.employeeWorkTime.model.checker.EmpwotmCheckSoftDelete;
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

public final class NodeEmpwotmInsert implements DeciTree<EmpwotmInfo> {
	private DeciTree<EmpwotmInfo> tree;
	
	
	public NodeEmpwotmInsert(DeciTreeOption<EmpwotmInfo> option) {
		DeciTreeHelperOption<EmpwotmInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpwotmInfo> buildDecisionChecker(DeciTreeOption<EmpwotmInfo> option) {
		List<ModelChecker<EmpwotmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpwotmInfo> checker;
		
		final boolean EXPECTED_NOT_DELETED = false;
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXPECTED_NOT_DELETED;
		checker = new EmpwotmCheckSoftDelete(checkerOption);
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmpwotmInfo>> buildActionsOnPassed(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpwotmInsert(option));
		return actions;
	}
	
	
	
	private List<ActionStd<EmpwotmInfo>> buildActionsOnFailed(DeciTreeOption<EmpwotmInfo> option) {
		List<ActionStd<EmpwotmInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmpwotmUpdate(option));
		return actions;
	}
	
	
	
	@Override public ActionStd<EmpwotmInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpwotmInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
