package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreStmtExecInsert;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.checker.CheckerStoreCnpj;
import br.com.gda.business.store.model.checker.CheckerStoreCnpjExistOnDb;
import br.com.gda.business.store.model.checker.CheckerStoreGenField;
import br.com.gda.business.store.model.checker.CheckerStoreMandatoryWrite;
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

public final class StoreRootInsert implements DecisionTree<StoreInfo> {
	private DecisionTree<StoreInfo> tree;
	
	
	public StoreRootInsert(DecisionTreeOption<StoreInfo> option) {
		DecisionTreeHelperOption<StoreInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreInfo> buildDecisionChecker(DecisionTreeOption<StoreInfo> option) {
		final boolean DONT_EXIST_ON_DB = false;	
		
		List<ModelChecker<StoreInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerStoreMandatoryWrite();
		stack.add(checker);
		
		checker = new CheckerStoreGenField();
		stack.add(checker);
		
		checker = new CheckerStoreCnpj();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new CheckerStoreCnpjExistOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionAction<StoreInfo>> buildActionsOnPassed(DecisionTreeOption<StoreInfo> option) {
		List<DecisionAction<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		actions.add(new StoreActionSelect(option));		
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
	
	
	

	
	
	
	private static class ActionInsert implements DecisionAction<StoreInfo> {
		DecisionAction<StoreInfo> actionHelper;
		
		
		public ActionInsert(DecisionTreeOption<StoreInfo> option) {
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
			
			return new StoreStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<StoreInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
