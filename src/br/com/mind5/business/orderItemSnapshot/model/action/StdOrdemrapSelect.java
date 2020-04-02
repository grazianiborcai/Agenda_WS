package br.com.mind5.business.orderItemSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.dao.OrdemrapSelect;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemrapSelect implements ActionStd<OrdemrapInfo> {
	private ActionStd<OrdemrapInfo> actionHelper;
	
	
	public StdOrdemrapSelect(DeciTreeOption<OrdemrapInfo> option) {
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
		
		return new OrdemrapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdemrapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdemrapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
