package br.com.mind5.business.storeLeaveDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.dao.StolateDelete;
import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolateDelete implements ActionStdV1<StolateInfo> {
	private ActionStdV1<StolateInfo> actionHelper;
	
	
	public StdStolateDelete(DeciTreeOption<StolateInfo> option) {
		DaoStmtExec_<StolateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<StolateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
