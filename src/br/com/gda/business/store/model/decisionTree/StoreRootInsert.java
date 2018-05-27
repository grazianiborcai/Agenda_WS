package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreStmtExecInsert;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.CheckerStoreCnpj;
import br.com.gda.business.store.model.checker.CheckerStoreCnpjExist;
import br.com.gda.business.store.model.checker.CheckerStoreGenField;
import br.com.gda.business.store.model.checker.CheckerStoreWrite;
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

public final class StoreRootInsert implements DeciTree<StoreInfo> {
	private DeciTree<StoreInfo> tree;
	
	
	public StoreRootInsert(DeciTreeOption<StoreInfo> option) {
		DeciTreeHelperOption<StoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DeciTreeOption<StoreInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;	
		
		List<ModelChecker<StoreInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerStoreWrite();
		stack.add(checker);
		
		checker = new CheckerStoreGenField();
		stack.add(checker);
		
		checker = new CheckerStoreCnpj();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CheckerStoreCnpjExist(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<StoreInfo>> buildActionsOnPassed(DeciTreeOption<StoreInfo> option) {
		List<DeciAction<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		actions.add(new StoreActionSelect(option));		
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
	
	
	

	
	
	
	private static class ActionInsert implements DeciAction<StoreInfo> {
		DeciAction<StoreInfo> actionHelper;
		
		
		public ActionInsert(DeciTreeOption<StoreInfo> option) {
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
			
			return new StoreStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DeciResult<StoreInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
