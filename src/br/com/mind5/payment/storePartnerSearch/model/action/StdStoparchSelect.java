package br.com.mind5.payment.storePartnerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.dao.StoparchSelect;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StdStoparchSelect implements ActionStdV1<StoparchInfo> {
	private ActionStdV1<StoparchInfo> actionHelper;
	
	
	public StdStoparchSelect(DeciTreeOption<StoparchInfo> option) {
		DaoStmtExec_<StoparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StoparchInfo> buildStmtExec(DeciTreeOption<StoparchInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<StoparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
