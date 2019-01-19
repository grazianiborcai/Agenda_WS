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
import br.com.gda.payService.payCustomer.dao.PaycusInsert;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class StdPaycusInsert implements ActionStd<PaycusInfo> {
	private ActionStd<PaycusInfo> actionHelper;
	
	
	public StdPaycusInsert(DeciTreeOption<PaycusInfo> option) {
		DaoStmtExec<PaycusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PaycusInfo> buildStmtExec(DeciTreeOption<PaycusInfo> option) {
		List<DaoStmtExecOption<PaycusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PaycusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PaycusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PaycusInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaycusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaycusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
