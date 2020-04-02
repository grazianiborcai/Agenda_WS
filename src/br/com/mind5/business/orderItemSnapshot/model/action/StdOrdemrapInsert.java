package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.dao.OrdemrapInsert;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemrapInsert implements ActionStdV1<OrdemrapInfo> {
	private ActionStdV1<OrdemrapInfo> actionHelper;
	
	
	public StdOrdemrapInsert(DeciTreeOption<OrdemrapInfo> option) {
		DaoStmtExec_<OrdemrapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrdemrapInfo> buildStmtExec(DeciTreeOption<OrdemrapInfo> option) {
		List<DaoStmtExecOption<OrdemrapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrdemrapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrdemrapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrdemrapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OrdemrapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdemrapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
