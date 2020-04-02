package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao.PeresmoipSelect;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipSelect implements ActionStdV1<PeresmoipInfo> {
	private ActionStdV1<PeresmoipInfo> actionHelper;
	
	
	public StdPeresmoipSelect(DeciTreeOption<PeresmoipInfo> option) {
		DaoStmtExec_<PeresmoipInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
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
		
		return new PeresmoipSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PeresmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PeresmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
