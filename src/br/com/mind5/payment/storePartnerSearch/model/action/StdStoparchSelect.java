package br.com.mind5.payment.storePartnerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.dao.StoparchSelect;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StdStoparchSelect implements ActionStd<StoparchInfo> {
	private ActionStd<StoparchInfo> actionHelper;
	
	
	public StdStoparchSelect(DeciTreeOption<StoparchInfo> option) {
		DaoStmtExec<StoparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoparchInfo> buildStmtExec(DeciTreeOption<StoparchInfo> option) {
		List<DaoStmtExecOption<StoparchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoparchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoparchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoparchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
