package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreStmtExecDelete;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.CheckerStoreExistOnDb;
import br.com.gda.business.store.model.checker.CheckerStoreMandatoryKey;
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

public final class StoreRootDelete implements DecisionTree<StoreInfo> {
	private DecisionTree<StoreInfo> tree;
	
	
	public StoreRootDelete(DecisionTreeOption<StoreInfo> option) {
		DecisionTreeHelperOption<StoreInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DecisionTreeOption<StoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean KEY_NOT_NULL = true;	
		
		List<ModelChecker<StoreInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;
		checker = new CheckerStoreMandatoryKey(checkerOption);
		stack.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerStoreExistOnDb(checkerOption);
		stack.add(checker);		
		
		 return new ModelCheckerStack<StoreInfo>(stack);
	}
	
	
	
	private List<DecisionAction<StoreInfo>> buildActionsOnPassed(DecisionTreeOption<StoreInfo> option) {
		List<DecisionAction<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionDelete(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DecisionChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DecisionResult<StoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
		
	private static class ActionDelete implements DecisionAction<StoreInfo> {
		DecisionAction<StoreInfo> actionHelper;
		
		
		public ActionDelete(DecisionTreeOption<StoreInfo> option) {
			SqlStmtExec<StoreInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<StoreInfo> buildStmtExec(DecisionTreeOption<StoreInfo> option) {
			List<SqlStmtExecOption<StoreInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(StoreInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<StoreInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new StoreStmtExecDelete(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<StoreInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
