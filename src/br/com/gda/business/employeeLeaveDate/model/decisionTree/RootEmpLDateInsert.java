package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckEmp;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckExist;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckOwner;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckStore;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckStoreEmp;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckTimeRange;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpLDateInsert implements DeciTree<EmpLDateInfo> {
	private DeciTree<EmpLDateInfo> tree;
	
	
	public RootEmpLDateInsert(DeciTreeOption<EmpLDateInfo> option) {
		DeciTreeHelperOption<EmpLDateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpLDateInfo> buildDecisionChecker(DeciTreeOption<EmpLDateInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<EmpLDateInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpLDateInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpLDateCheckWrite();
		stack.add(checker);
		
		checker = new EmpLDateCheckTimeRange();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckOwner(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckEmp(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckStore(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckStoreEmp(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmpLDateCheckExist(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerQueue<>(stack);
	}
	
	
	
	private List<DeciAction<EmpLDateInfo>> buildActionsOnPassed(DeciTreeOption<EmpLDateInfo> option) {
		List<DeciAction<EmpLDateInfo>> actions = new ArrayList<>();		
		actions.add(new NodeEmpLDateInsert(option).toAction());	
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
	
	
	
	@Override public DeciAction<EmpLDateInfo> toAction() {
		return tree.toAction();
	}
}
