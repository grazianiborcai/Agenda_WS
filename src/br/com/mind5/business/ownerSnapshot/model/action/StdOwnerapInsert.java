package br.com.mind5.business.ownerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.dao.OwnerapInsert;
import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerapInsert implements ActionStdV1<OwnerapInfo> {
	private ActionStdV1<OwnerapInfo> actionHelper;
	
	
	public StdOwnerapInsert(DeciTreeOption<OwnerapInfo> option) {
		DaoStmtExec_<OwnerapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OwnerapInfo> buildStmtExec(DeciTreeOption<OwnerapInfo> option) {
		List<DaoStmtExecOption<OwnerapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnerapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnerapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnerapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OwnerapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
