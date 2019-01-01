package br.com.gda.payService.payCustomer.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.dao.PayCusUpdate;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class StdPayCusUpdate implements ActionStd<PayCusInfo> {
	private ActionStd<PayCusInfo> actionHelper;
	
	
	public StdPayCusUpdate(DeciTreeOption<PayCusInfo> option) {
		DaoStmtExec<PayCusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayCusInfo> buildStmtExec(DeciTreeOption<PayCusInfo> option) {
		List<DaoStmtExecOption<PayCusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayCusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayCusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayCusUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayCusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayCusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
