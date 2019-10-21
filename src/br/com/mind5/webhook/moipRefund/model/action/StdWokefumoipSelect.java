package br.com.mind5.webhook.moipRefund.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.dao.WokefumoipSelect;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipSelect implements ActionStd<WokefumoipInfo> {
	private ActionStd<WokefumoipInfo> actionHelper;
	
	
	public StdWokefumoipSelect(DeciTreeOption<WokefumoipInfo> option) {
		DaoStmtExec<WokefumoipInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<WokefumoipInfo> buildStmtExec(DeciTreeOption<WokefumoipInfo> option) {
		List<DaoStmtExecOption<WokefumoipInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(WokefumoipInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<WokefumoipInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new WokefumoipSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<WokefumoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokefumoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
