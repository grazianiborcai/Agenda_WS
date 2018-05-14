package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreEmpStmtExecDelete;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.checker.CheckerStoreEmpExistOnDb;
import br.com.gda.business.store.model.checker.CheckerStoreEmpMandatoryKey;
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

public final class StoreEmpRootDelete implements DecisionTree<StoreEmpInfo> {
	private DecisionTree<StoreEmpInfo> tree;
	
	
	public StoreEmpRootDelete(DecisionTreeOption<StoreEmpInfo> option) {
		DecisionTreeHelperOption<StoreEmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DecisionTreeOption<StoreEmpInfo> option) {
		List<ModelChecker<StoreEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;
		
		final boolean KEY_NOT_NULL = true;	
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;		
		checker = new CheckerStoreEmpMandatoryKey(checkerOption);
		stack.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerStoreEmpExistOnDb(checkerOption);
		stack.add(checker);		
		
		 return new ModelCheckerStack<StoreEmpInfo>(stack);
	}
	
	
	
	private List<DecisionAction<StoreEmpInfo>> buildActionsOnPassed(DecisionTreeOption<StoreEmpInfo> option) {
		List<DecisionAction<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionDelete(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<StoreEmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
		
	private static class ActionDelete implements DecisionAction<StoreEmpInfo> {
		DecisionAction<StoreEmpInfo> actionHelper;
		
		
		public ActionDelete(DecisionTreeOption<StoreEmpInfo> option) {
			SqlStmtExec<StoreEmpInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<StoreEmpInfo> buildStmtExec(DecisionTreeOption<StoreEmpInfo> option) {
			List<SqlStmtExecOption<StoreEmpInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(StoreEmpInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<StoreEmpInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new StoreEmpStmtExecDelete(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<StoreEmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
