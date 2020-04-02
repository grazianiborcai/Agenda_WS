package br.com.mind5.payment.storePartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.dao.StoparSelect;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StdStoparSelect implements ActionStd<StoparInfo> {
	private ActionStd<StoparInfo> actionHelper;
	
	
	public StdStoparSelect(DeciTreeOption<StoparInfo> option) {
		DaoStmtExec_<StoparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StoparInfo> buildStmtExec(DeciTreeOption<StoparInfo> option) {
		List<DaoStmtExecOption<StoparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoparSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
