package br.com.mind5.payment.ownerPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.ownerPartner.dao.OwnparSelect;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparSelect implements ActionStdV1<OwnparInfo> {
	private ActionStdV1<OwnparInfo> actionHelper;
	
	
	public StdOwnparSelect(DeciTreeOption<OwnparInfo> option) {
		DaoStmtExec_<OwnparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OwnparInfo> buildStmtExec(DeciTreeOption<OwnparInfo> option) {
		List<DaoStmtExecOption<OwnparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnparSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OwnparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
