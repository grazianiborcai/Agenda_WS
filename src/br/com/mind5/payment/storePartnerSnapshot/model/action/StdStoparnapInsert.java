package br.com.mind5.payment.storePartnerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.dao.StoparnapInsert;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StdStoparnapInsert implements ActionStdV1<StoparnapInfo> {
	private ActionStdV1<StoparnapInfo> actionHelper;
	
	
	public StdStoparnapInsert(DeciTreeOption<StoparnapInfo> option) {
		DaoStmtExec_<StoparnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StoparnapInfo> buildStmtExec(DeciTreeOption<StoparnapInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<StoparnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoparnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
