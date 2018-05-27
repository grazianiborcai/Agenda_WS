package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreStmtExecDelete;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.CheckerStoreExist;
import br.com.gda.business.store.model.checker.CheckerStoreKey;
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

public final class StoreRootDelete implements DeciTree<StoreInfo> {
	private DeciTree<StoreInfo> tree;
	
	
	public StoreRootDelete(DeciTreeOption<StoreInfo> option) {
		DeciTreeHelperOption<StoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DeciTreeOption<StoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		final boolean KEY_NOT_NULL = true;	
		
		List<ModelChecker<StoreInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;
		checker = new CheckerStoreKey(checkerOption);
		stack.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerStoreExist(checkerOption);
		stack.add(checker);		
		
		 return new ModelCheckerStack<StoreInfo>(stack);
	}
	
	
	
	private List<DeciAction<StoreInfo>> buildActionsOnPassed(DeciTreeOption<StoreInfo> option) {
		List<DeciAction<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionDelete(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
		
	private static class ActionDelete implements DeciAction<StoreInfo> {
		DeciAction<StoreInfo> actionHelper;
		
		
		public ActionDelete(DeciTreeOption<StoreInfo> option) {
			SqlStmtExec<StoreInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<StoreInfo> buildStmtExec(DeciTreeOption<StoreInfo> option) {
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
		
		
		
		@Override public DeciResult<StoreInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
