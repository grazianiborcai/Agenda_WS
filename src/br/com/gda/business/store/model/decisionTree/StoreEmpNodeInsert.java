package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreEmpStmtExecInsert;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.checker.CheckerStoreEmpWrite;
import br.com.gda.business.store.model.checker.CheckerStoreEmpSoftDelete;
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

public final class StoreEmpNodeInsert implements DeciTree<StoreEmpInfo> {
	private DeciTree<StoreEmpInfo> tree;
	
	
	public StoreEmpNodeInsert(DeciTreeOption<StoreEmpInfo> option) {
		DeciTreeHelperOption<StoreEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DeciTreeOption<StoreEmpInfo> option) {
		final boolean STORE_EMP_NOT_DELETED = false;	
		
		List<ModelChecker<StoreEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerStoreEmpWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = STORE_EMP_NOT_DELETED;		
		checker = new CheckerStoreEmpSoftDelete(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<StoreEmpInfo>> buildActionsOnPassed(DeciTreeOption<StoreEmpInfo> option) {
		List<DeciAction<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		actions.add(new StoreEmpActionSelect(option));		
		return actions;
	}
	
	
	
	private List<DeciAction<StoreEmpInfo>> buildActionsOnFailed(DeciTreeOption<StoreEmpInfo> option) {
		List<DeciAction<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new StoreEmpActionUpdate(option));
		actions.add(new StoreEmpActionSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
	
	
	private static class ActionInsert implements DeciAction<StoreEmpInfo> {
		DeciAction<StoreEmpInfo> actionHelper;
		
		
		public ActionInsert(DeciTreeOption<StoreEmpInfo> option) {
			SqlStmtExec<StoreEmpInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<StoreEmpInfo> buildStmtExec(DeciTreeOption<StoreEmpInfo> option) {
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
		
		
		
		@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
