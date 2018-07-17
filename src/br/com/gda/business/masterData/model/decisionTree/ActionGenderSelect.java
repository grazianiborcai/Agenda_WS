package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.GenderSelect;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionGenderSelect implements DeciAction<GenderInfo> {
	private DeciAction<GenderInfo> actionHelper;
	
	
	public ActionGenderSelect(DeciTreeOption<GenderInfo> option) {
		SqlStmtExec<GenderInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<GenderInfo> buildStmtExec(DeciTreeOption<GenderInfo> option) {
		List<SqlStmtExecOption<GenderInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(GenderInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<GenderInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new GenderSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<GenderInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<GenderInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
