package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.PayPartnerSelect;
import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPayPartnerSelect implements ActionStd<PayPartnerInfo> {
	private ActionStd<PayPartnerInfo> actionHelper;
	
	
	public StdPayPartnerSelect(DeciTreeOption<PayPartnerInfo> option) {
		DaoStmtExec<PayPartnerInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayPartnerInfo> buildStmtExec(DeciTreeOption<PayPartnerInfo> option) {
		List<DaoStmtExecOption<PayPartnerInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayPartnerInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayPartnerInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayPartnerSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayPartnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayPartnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
