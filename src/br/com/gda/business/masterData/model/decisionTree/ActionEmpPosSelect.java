package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.EmpPosSelect;
import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionEmpPosSelect implements DeciAction<EmpPosInfo> {
	private DeciAction<EmpPosInfo> actionHelper;
	
	
	public ActionEmpPosSelect(DeciTreeOption<EmpPosInfo> option) {
		SqlStmtExec<EmpPosInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<EmpPosInfo> buildStmtExec(DeciTreeOption<EmpPosInfo> option) {
		List<SqlStmtExecOption<EmpPosInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpPosInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<EmpPosInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpPosSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<EmpPosInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpPosInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
