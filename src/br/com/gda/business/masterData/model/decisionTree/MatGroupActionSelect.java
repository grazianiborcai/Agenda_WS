package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatGroupSelectExec;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionStmtHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatGroupActionSelect implements DeciAction<MatGroupInfo> {
	private DeciAction<MatGroupInfo> actionHelper;
	
	
	public MatGroupActionSelect(DeciTreeOption<MatGroupInfo> option) {
		SqlStmtExec<MatGroupInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
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
		
		return new MatGroupSelectExec(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatGroupInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
