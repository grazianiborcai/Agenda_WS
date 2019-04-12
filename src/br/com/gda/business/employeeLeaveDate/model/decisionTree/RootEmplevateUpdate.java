package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateSelect;
import br.com.gda.business.employeeLeaveDate.model.action.StdEmplevateUpdate;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckEmp;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckExist;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckKey;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckOwner;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckStore;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckStoreEmp;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckTimeRange;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckWrite;
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

public final class RootEmplevateUpdate implements DeciTree<EmplevateInfo> {
	private DeciTree<EmplevateInfo> tree;
	
	
	public RootEmplevateUpdate(DeciTreeOption<EmplevateInfo> option) {
		DeciTreeHelperOption<EmplevateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.conn = option.conn;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmplevateInfo> buildDecisionChecker(DeciTreeOption<EmplevateInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<EmplevateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplevateInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checker = new EmplevateCheckWrite();
		queue.add(checker);
		
		checker = new EmplevateCheckKey();
		queue.add(checker);
		
		checker = new EmplevateCheckTimeRange();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckStoreEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmplevateCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmplevateInfo>> buildActionsOnPassed(DeciTreeOption<EmplevateInfo> option) {
		List<ActionStd<EmplevateInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEmplevateUpdate(option));
		actions.add(new StdEmplevateSelect(option));
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
