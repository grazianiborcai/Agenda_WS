package br.com.mind5.business.customer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.dao.CusDelete;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusDelete implements ActionStdV1<CusInfo> {
	private ActionStdV1<CusInfo> actionHelper;
	
	
	public StdCusDelete(DeciTreeOption<CusInfo> option) {
		DaoStmtExec_<CusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CusInfo> buildStmtExec(DeciTreeOption<CusInfo> option) {
		List<DaoStmtExecOption<CusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
