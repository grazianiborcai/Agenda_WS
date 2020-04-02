package br.com.mind5.security.storeAuthorization.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.storeAuthorization.dao.StorauthSelect;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StdStorauthSelect implements ActionStdV1<StorauthInfo> {
	private ActionStdV1<StorauthInfo> actionHelper;
	
	
	public StdStorauthSelect(DeciTreeOption<StorauthInfo> option) {
		DaoStmtExec_<StorauthInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StorauthInfo> buildStmtExec(DeciTreeOption<StorauthInfo> option) {
		List<DaoStmtExecOption<StorauthInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StorauthInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StorauthInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StorauthSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StorauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
