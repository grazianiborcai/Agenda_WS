package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.CartCategSelect;
import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionCartCategSelect implements DeciAction<CartCategInfo> {
	private DeciAction<CartCategInfo> actionHelper;
	
	
	public ActionCartCategSelect(DeciTreeOption<CartCategInfo> option) {
		DaoStmtExec<CartCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CartCategInfo> buildStmtExec(DeciTreeOption<CartCategInfo> option) {
		List<DaoStmtExecOption<CartCategInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CartCategInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CartCategInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CartCategSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<CartCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
