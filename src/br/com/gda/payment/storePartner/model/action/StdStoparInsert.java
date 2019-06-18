package br.com.gda.payment.storePartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartner.dao.StoparInsert;
import br.com.gda.payment.storePartner.info.StoparInfo;

public final class StdStoparInsert implements ActionStd<StoparInfo> {
	private ActionStd<StoparInfo> actionHelper;
	
	
	public StdStoparInsert(DeciTreeOption<StoparInfo> option) {
		DaoStmtExec<StoparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoparInfo> buildStmtExec(DeciTreeOption<StoparInfo> option) {
		List<DaoStmtExecOption<StoparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoparInsert(stmtExecOptions);
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
