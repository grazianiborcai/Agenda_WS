package br.com.mind5.payment.payOrder.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.dao.PayordInsert;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class StdPayordInsert implements ActionStdV1<PayordInfo> {
	private ActionStdV1<PayordInfo> actionHelper;
	
	
	public StdPayordInsert(DeciTreeOption<PayordInfo> option) {
		DaoStmtExec_<PayordInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PayordInfo> buildStmtExec(DeciTreeOption<PayordInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayordInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
