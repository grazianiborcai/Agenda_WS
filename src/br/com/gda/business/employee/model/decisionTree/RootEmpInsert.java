package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpInsertExec;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.EmpCheckCpf;
import br.com.gda.business.employee.model.checker.EmpCheckExistCpf;
import br.com.gda.business.employee.model.checker.EmpCheckGenField;
import br.com.gda.business.employee.model.checker.EmpCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionStmtHelper;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class RootEmpInsert implements DeciTree<EmpInfo> {
	private DeciTree<EmpInfo> tree;
	
	
	public RootEmpInsert(DeciTreeOption<EmpInfo> option) {
		DeciTreeHelperOption<EmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DeciTreeOption<EmpInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;	
		
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new EmpCheckWrite();
		stack.add(checker);
		
		checker = new EmpCheckGenField();
		stack.add(checker);
		
		checker = new EmpCheckCpf();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmpCheckExistCpf(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<EmpInfo>> buildActionsOnPassed(DeciTreeOption<EmpInfo> option) {
		List<DeciAction<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		actions.add(new ActionEmpSelect(option));		
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
	
	
	

	
	
	
	private static class ActionInsert implements DeciAction<EmpInfo> {
		DeciAction<EmpInfo> actionHelper;
		
		
		public ActionInsert(DeciTreeOption<EmpInfo> option) {
			SqlStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpInfo> buildStmtExec(DeciTreeOption<EmpInfo> option) {
			List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpInsertExec(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DeciResult<EmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
