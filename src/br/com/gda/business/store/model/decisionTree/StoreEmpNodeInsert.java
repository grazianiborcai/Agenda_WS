package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreEmpStmtExecInsert;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.checker.CheckerStoreEmpMandatoryWrite;
import br.com.gda.business.store.model.checker.CheckerStoreEmpSoftDelete;
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

public final class StoreEmpNodeInsert implements DecisionTree<StoreEmpInfo> {
	private DecisionTree<StoreEmpInfo> tree;
	
	
	public StoreEmpNodeInsert(DecisionTreeOption<StoreEmpInfo> option) {
		DecisionTreeHelperOption<StoreEmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DecisionTreeOption<StoreEmpInfo> option) {
		final boolean STORE_EMP_NOT_DELETED = false;	
		
		List<ModelChecker<StoreEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerStoreEmpMandatoryWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = STORE_EMP_NOT_DELETED;		
		checker = new CheckerStoreEmpSoftDelete(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<StoreEmpInfo>> buildActionsOnPassed(DecisionTreeOption<StoreEmpInfo> option) {
		List<DecisionAction<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		actions.add(new StoreEmpActionSelect(option));		
		return actions;
	}
	
	
	
	private List<DecisionAction<StoreEmpInfo>> buildActionsOnFailed(DecisionTreeOption<StoreEmpInfo> option) {
		List<DecisionAction<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StoreEmpActionUpdate(option));
		actions.add(new StoreEmpActionSelect(option));		
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
	
	
	

	
	
	
	private static class ActionInsert implements DecisionAction<StoreEmpInfo> {
		DecisionAction<StoreEmpInfo> actionHelper;
		
		
		public ActionInsert(DecisionTreeOption<StoreEmpInfo> option) {
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
			
			return new StoreEmpStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<StoreEmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
