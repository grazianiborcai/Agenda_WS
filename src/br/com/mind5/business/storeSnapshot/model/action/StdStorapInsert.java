package br.com.mind5.business.storeSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.dao.StorapInsert;
import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorapInsert implements ActionStdV1<StorapInfo> {
	private ActionStdV1<StorapInfo> actionHelper;
	
	
	public StdStorapInsert(DeciTreeOption<StorapInfo> option) {
		DaoStmtExec_<StorapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StorapInfo> buildStmtExec(DeciTreeOption<StorapInfo> option) {
		List<DaoStmtExecOption<StorapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StorapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StorapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StorapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StorapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StorapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
