package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.EmpPositionStmtExecSelect;
import br.com.gda.business.masterData.info.EmpPositionInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionStmtHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpPositionActionSelect implements DeciAction<EmpPositionInfo> {
	DeciAction<EmpPositionInfo> actionHelper;
	
	
	public EmpPositionActionSelect(DeciTreeOption<EmpPositionInfo> option) {
		SqlStmtExec<EmpPositionInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpPositionInfo> buildStmtExec(DeciTreeOption<EmpPositionInfo> option) {
		List<SqlStmtExecOption<EmpPositionInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpPositionInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpPositionInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpPositionStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpPositionInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
