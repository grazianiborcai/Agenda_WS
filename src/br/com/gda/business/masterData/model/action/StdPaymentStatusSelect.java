package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.PaymentStatusSelect;
import br.com.gda.business.masterData.info.PaymentStatusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPaymentStatusSelect implements ActionStd<PaymentStatusInfo> {
	private ActionStd<PaymentStatusInfo> actionHelper;
	
	
	public StdPaymentStatusSelect(DeciTreeOption<PaymentStatusInfo> option) {
		DaoStmtExec<PaymentStatusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PaymentStatusInfo> buildStmtExec(DeciTreeOption<PaymentStatusInfo> option) {
		List<DaoStmtExecOption<PaymentStatusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PaymentStatusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PaymentStatusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PaymentStatusSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PaymentStatusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaymentStatusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
