package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.dao.StolateDelete;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolateDelete implements ActionStd<StolateInfo> {
	private ActionStd<StolateInfo> actionHelper;
	
	
	public StdStolateDelete(DeciTreeOption<StolateInfo> option) {
		DaoStmtExec_<StolateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StolateInfo> buildStmtExec(DeciTreeOption<StolateInfo> option) {
		List<DaoStmtExecOption<StolateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolateDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
