package br.com.gda.payService.payPartnerStore.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerStore.dao.PayPartnerStoreSelect;
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;

public final class StdPayPartnerStoreSelect implements ActionStd<PayPartnerStoreInfo> {
	private ActionStd<PayPartnerStoreInfo> actionHelper;
	
	
	public StdPayPartnerStoreSelect(DeciTreeOption<PayPartnerStoreInfo> option) {
		DaoStmtExec<PayPartnerStoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayPartnerStoreInfo> buildStmtExec(DeciTreeOption<PayPartnerStoreInfo> option) {
		List<DaoStmtExecOption<PayPartnerStoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayPartnerStoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayPartnerStoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayPartnerStoreSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayPartnerStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayPartnerStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
