package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.dao.OwnerSelect;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

final class ActionOwnerSelect implements DeciAction<OwnerInfo> {
	private DeciAction<OwnerInfo> actionHelper;
	
	
	public ActionOwnerSelect(DeciTreeOption<OwnerInfo> option) {
		SqlStmtExec<OwnerInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<OwnerInfo> buildStmtExec(DeciTreeOption<OwnerInfo> option) {
		List<SqlStmtExecOption<OwnerInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnerInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<OwnerInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnerSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
