package br.com.gda.payment.payOrder.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrder.dao.PayordUpdate;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class StdPayordUpdate implements ActionStd<PayordInfo> {
	private ActionStd<PayordInfo> actionHelper;
	
	
	public StdPayordUpdate(DeciTreeOption<PayordInfo> option) {
		DaoStmtExec<PayordInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayordInfo> buildStmtExec(DeciTreeOption<PayordInfo> option) {
		List<DaoStmtExecOption<PayordInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayordInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayordInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayordUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
