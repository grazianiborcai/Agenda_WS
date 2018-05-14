package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpStmtExecInsert;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.CheckerEmpCpf;
import br.com.gda.business.employee.model.checker.CheckerEmpCpfExistOnDb;
import br.com.gda.business.employee.model.checker.CheckerEmpGenField;
import br.com.gda.business.employee.model.checker.CheckerEmpMandatoryWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpRootInsert implements DecisionTree<EmpInfo> {
	private DecisionTree<EmpInfo> tree;
	
	
	public EmpRootInsert(DecisionTreeOption<EmpInfo> option) {
		DecisionTreeHelperOption<EmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DecisionTreeOption<EmpInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;	
		
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerEmpMandatoryWrite();
		stack.add(checker);
		
		checker = new CheckerEmpGenField();
		stack.add(checker);
		
		checker = new CheckerEmpCpf();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CheckerEmpCpfExistOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<EmpInfo>> buildActionsOnPassed(DecisionTreeOption<EmpInfo> option) {
		List<DecisionAction<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		actions.add(new EmpActionSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<EmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
	
	
	private static class ActionInsert implements DecisionAction<EmpInfo> {
		DecisionAction<EmpInfo> actionHelper;
		
		
		public ActionInsert(DecisionTreeOption<EmpInfo> option) {
			SqlStmtExec<EmpInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpInfo> buildStmtExec(DecisionTreeOption<EmpInfo> option) {
			List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<EmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
