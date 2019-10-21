package br.com.mind5.payment.payOrder.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.dao.PayordInsert;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class StdPayordInsert implements ActionStd<PayordInfo> {
	private ActionStd<PayordInfo> actionHelper;
	
	
	public StdPayordInsert(DeciTreeOption<PayordInfo> option) {
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
		
		return new PayordInsert(stmtExecOptions);
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
