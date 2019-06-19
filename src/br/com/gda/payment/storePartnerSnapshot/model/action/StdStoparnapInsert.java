package br.com.gda.payment.storePartnerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartnerSnapshot.dao.StoparnapInsert;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StdStoparnapInsert implements ActionStd<StoparnapInfo> {
	private ActionStd<StoparnapInfo> actionHelper;
	
	
	public StdStoparnapInsert(DeciTreeOption<StoparnapInfo> option) {
		DaoStmtExec<StoparnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoparnapInfo> buildStmtExec(DeciTreeOption<StoparnapInfo> option) {
		List<DaoStmtExecOption<StoparnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoparnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoparnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoparnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoparnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
