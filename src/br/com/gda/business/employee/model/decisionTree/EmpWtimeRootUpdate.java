package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpWtimeStmtExecUpdate;
import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.business.employee.model.checker.CheckerEmpWtimeExistOnDb;
import br.com.gda.business.employee.model.checker.CheckerEmpWtimeMandatoryWrite;
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

public final class EmpWtimeRootUpdate implements DecisionTree<EmpWTimeInfo> {
	private DecisionTree<EmpWTimeInfo> tree;
	
	
	public EmpWtimeRootUpdate(DecisionTreeOption<EmpWTimeInfo> option) {
		DecisionTreeHelperOption<EmpWTimeInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.conn = option.conn;
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker(DecisionTreeOption<EmpWTimeInfo> option) {
		List<ModelChecker<EmpWTimeInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;
		
		checker = new CheckerEmpWtimeExistOnDb(checkerOption);
		stack.add(checker);		
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<EmpWTimeInfo>> buildActionsOnPassed(DecisionTreeOption<EmpWTimeInfo> option) {
		List<DecisionAction<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionUpdate(option));
		actions.add(new EmpWtimeActionSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
		
	private static class ActionUpdate implements DecisionAction<EmpWTimeInfo> {
		DecisionAction<EmpWTimeInfo> actionHelper;
		
		
		public ActionUpdate(DecisionTreeOption<EmpWTimeInfo> option) {
			SqlStmtExec<EmpWTimeInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<EmpWTimeInfo> buildStmtExec(DecisionTreeOption<EmpWTimeInfo> option) {
			List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(EmpWTimeInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new EmpWtimeStmtExecUpdate(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<EmpWTimeInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
