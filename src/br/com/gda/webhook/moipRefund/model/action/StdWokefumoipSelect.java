package br.com.gda.webhook.moipRefund.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipRefund.dao.WokefumoipSelect;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

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
