package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreEmpStmtExecUpdate;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.model.checker.CheckerStoreEmpDependencyOnDb;
import br.com.gda.business.store.model.checker.CheckerStoreEmpExistOnDb;
import br.com.gda.business.store.model.checker.CheckerStoreEmpMandatoryWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DecisionActionAdapter;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionChoice;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTree;
import br.com.gda.model.decisionTree.DecisionTreeHelper;
import br.com.gda.model.decisionTree.DecisionTreeHelperOption;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreEmpRootUpdate implements DecisionTree<StoreEmpInfo> {
	private DecisionTree<StoreEmpInfo> tree;
	
	
	public StoreEmpRootUpdate(DecisionTreeOption<StoreEmpInfo> option) {
		DecisionTreeHelperOption<StoreEmpInfo> helperOption = new DecisionTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.conn = option.conn;
		
		tree = new DecisionTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreEmpInfo> buildDecisionChecker(DecisionTreeOption<StoreEmpInfo> option) {
		List<ModelChecker<StoreEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<StoreEmpInfo> checker;
		ModelCheckerOption checkerOption;
		final boolean EXIST_ON_DB = true;
		
		checker = new CheckerStoreEmpMandatoryWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerStoreEmpDependencyOnDb(checkerOption);
		stack.add(checker);			
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerStoreEmpExistOnDb(checkerOption);
		stack.add(checker);		
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DecisionActionAdapter<StoreEmpInfo>> buildActionsOnPassed(DecisionTreeOption<StoreEmpInfo> option) {
		List<DecisionActionAdapter<StoreEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionUpdate(option));
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
	
	
	

	
		
	private static class ActionUpdate implements DecisionActionAdapter<StoreEmpInfo> {
		DecisionActionAdapter<StoreEmpInfo> actionHelper;
		
		
		public ActionUpdate(DecisionTreeOption<StoreEmpInfo> option) {
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
			
			return new StoreEmpStmtExecUpdate(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DecisionResult<StoreEmpInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
