package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.dao.MatStmtExecInsert;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.checker.CheckerMatGenField;
import br.com.gda.business.material.model.checker.CheckerMatMandatoryWrite;
import br.com.gda.model.checker.ModelChecker;
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

public final class MatRootInsert implements DeciTree<MatInfo> {
	private DeciTree<MatInfo> tree;
	
	
	public MatRootInsert(DeciTreeOption<MatInfo> option) {
		DeciTreeHelperOption<MatInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatInfo> buildDecisionChecker(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> stack = new ArrayList<>();		
		ModelChecker<MatInfo> checker;	
		
		checker = new CheckerMatMandatoryWrite();
		stack.add(checker);
		
		checker = new CheckerMatGenField();
		stack.add(checker);
		
		//TODO: verificar se barcode ou código do fornecedor já existe  no banco
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<MatInfo>> buildActionsOnPassed(DeciTreeOption<MatInfo> option) {
		List<DeciAction<MatInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionInsert(option));
		actions.add(new MatActionSelect(option));		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
	
	
	private static class ActionInsert implements DeciAction<MatInfo> {
		DeciAction<MatInfo> actionHelper;
		
		
		public ActionInsert(DeciTreeOption<MatInfo> option) {
			SqlStmtExec<MatInfo> sqlStmtExecutor = buildStmtExec(option);
			actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
		}
		
		
		
		private SqlStmtExec<MatInfo> buildStmtExec(DeciTreeOption<MatInfo> option) {
			List<SqlStmtExecOption<MatInfo>> stmtExecOptions = new ArrayList<>();			
			
			for(MatInfo eachRecord : option.recordInfos) {
				SqlStmtExecOption<MatInfo> stmtExecOption = new SqlStmtExecOption<>();
				stmtExecOption.conn = option.conn;
				stmtExecOption.recordInfo = eachRecord;
				stmtExecOption.schemaName = option.schemaName;
				stmtExecOptions.add(stmtExecOption);
			}
			
			return new MatStmtExecInsert(stmtExecOptions);
		}
		
		
		
		@Override public boolean executeAction() {			
			return actionHelper.executeAction();
		}
		
		
		
		@Override public DeciResult<MatInfo> getDecisionResult() {
			return actionHelper.getDecisionResult();
		}
	}
}
