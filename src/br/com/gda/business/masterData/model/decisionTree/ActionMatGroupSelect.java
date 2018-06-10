package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatGroupSelect;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionMatGroupSelect implements DeciAction<MatGroupInfo> {
	private DeciAction<MatGroupInfo> actionHelper;
	
	
	public ActionMatGroupSelect(DeciTreeOption<MatGroupInfo> option) {
		SqlStmtExec<MatGroupInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<MatGroupInfo> buildStmtExec(DeciTreeOption<MatGroupInfo> option) {
		List<SqlStmtExecOption<MatGroupInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatGroupInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<MatGroupInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatGroupSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatGroupInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatGroupInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
