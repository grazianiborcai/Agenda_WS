package br.com.mind5.business.ownerList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.dao.OwnelisSelect;
import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnelisSelect implements ActionStd<OwnelisInfo> {
	private ActionStd<OwnelisInfo> actionHelper;
	
	
	public StdOwnelisSelect(DeciTreeOption<OwnelisInfo> option) {
		DaoStmtExec<OwnelisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OwnelisInfo> buildStmtExec(DeciTreeOption<OwnelisInfo> option) {
		List<DaoStmtExecOption<OwnelisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnelisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnelisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnelisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnelisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnelisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
