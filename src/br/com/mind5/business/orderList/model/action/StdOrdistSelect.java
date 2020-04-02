package br.com.mind5.business.orderList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderList.dao.OrdistSelect;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdistSelect implements ActionStdV1<OrdistInfo> {
	private ActionStdV1<OrdistInfo> actionHelper;
	
	
	public StdOrdistSelect(DeciTreeOption<OrdistInfo> option) {
		DaoStmtExec_<OrdistInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrdistInfo> buildStmtExec(DeciTreeOption<OrdistInfo> option) {
		List<DaoStmtExecOption<OrdistInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrdistInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrdistInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrdistSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OrdistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
