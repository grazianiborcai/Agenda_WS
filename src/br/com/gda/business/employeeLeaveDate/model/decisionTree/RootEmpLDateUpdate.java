package br.com.gda.business.employeeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckEmp;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckExist;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckKey;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckOwner;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckStore;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckStoreEmp;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckTimeRange;
import br.com.gda.business.employeeLeaveDate.model.checker.EmpLDateCheckWrite;
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

public final class RootEmpLDateUpdate implements DeciTree<EmpLDateInfo> {
	private DeciTree<EmpLDateInfo> tree;
	
	
	public RootEmpLDateUpdate(DeciTreeOption<EmpLDateInfo> option) {
		DeciTreeHelperOption<EmpLDateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.conn = option.conn;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpLDateInfo> buildDecisionChecker(DeciTreeOption<EmpLDateInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<EmpLDateInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpLDateInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checker = new EmpLDateCheckWrite();
		queue.add(checker);
		
		checker = new EmpLDateCheckKey();
		queue.add(checker);
		
		checker = new EmpLDateCheckTimeRange();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckStoreEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpLDateCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmpLDateInfo>> buildActionsOnPassed(DeciTreeOption<EmpLDateInfo> option) {
		List<ActionStd<EmpLDateInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpLDateUpdate(option));
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
	
	
	
	@Override public ActionStd<EmpLDateInfo> toAction() {
		return tree.toAction();
	}
}
