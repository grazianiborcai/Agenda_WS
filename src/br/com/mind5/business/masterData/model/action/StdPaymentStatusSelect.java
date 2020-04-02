package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.PaymentStatusSelect;
import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPaymentStatusSelect implements ActionStdV1<PaymentStatusInfo> {
	private ActionStdV1<PaymentStatusInfo> actionHelper;
	
	
	public StdPaymentStatusSelect(DeciTreeOption<PaymentStatusInfo> option) {
		DaoStmtExec_<PaymentStatusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PaymentStatusInfo> buildStmtExec(DeciTreeOption<PaymentStatusInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<PaymentStatusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PaymentStatusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
