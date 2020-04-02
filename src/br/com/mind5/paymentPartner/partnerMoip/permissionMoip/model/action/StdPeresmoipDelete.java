package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao.PeresmoipDelete;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipDelete implements ActionStd<PeresmoipInfo> {
	private ActionStd<PeresmoipInfo> actionHelper;
	
	
	public StdPeresmoipDelete(DeciTreeOption<PeresmoipInfo> option) {
		DaoStmtExec_<PeresmoipInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PeresmoipInfo> buildStmtExec(DeciTreeOption<PeresmoipInfo> option) {
		List<DaoStmtExecOption<PeresmoipInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PeresmoipInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PeresmoipInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PeresmoipDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PeresmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PeresmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
