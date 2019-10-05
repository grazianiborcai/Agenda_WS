package br.com.gda.security.storeAuthorization.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.storeAuthorization.dao.StorauthSelect;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;

public final class StdStorauthSelect implements ActionStd<StorauthInfo> {
	private ActionStd<StorauthInfo> actionHelper;
	
	
	public StdStorauthSelect(DeciTreeOption<StorauthInfo> option) {
		DaoStmtExec<StorauthInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StorauthInfo> buildStmtExec(DeciTreeOption<StorauthInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazy<StorauthInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorauthInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
