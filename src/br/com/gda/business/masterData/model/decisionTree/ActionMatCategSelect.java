package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatCategSelectExec;
import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionMatCategSelect implements DeciAction<MatCategInfo> {
	private DeciAction<MatCategInfo> actionHelper;
	
	
	public ActionMatCategSelect(DeciTreeOption<MatCategInfo> option) {
		SqlStmtExec<MatCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<MatCategInfo> buildStmtExec(DeciTreeOption<MatCategInfo> option) {
		List<SqlStmtExecOption<MatCategInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatCategInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<MatCategInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatCategSelectExec(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
