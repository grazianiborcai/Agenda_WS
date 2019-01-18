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
import br.com.gda.payService.payPartnerStore.dao.PayparStoreSelect;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;

public final class StdPayparStoreSelect implements ActionStd<PayparStoreInfo> {
	private ActionStd<PayparStoreInfo> actionHelper;
	
	
	public StdPayparStoreSelect(DeciTreeOption<PayparStoreInfo> option) {
		DaoStmtExec<PayparStoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayparStoreInfo> buildStmtExec(DeciTreeOption<PayparStoreInfo> option) {
		List<DaoStmtExecOption<PayparStoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayparStoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayparStoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayparStoreSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayparStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayparStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
