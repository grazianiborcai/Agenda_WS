package br.com.mind5.payment.payOrderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.dao.PayordemInsert;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemInsert implements ActionStdV1<PayordemInfo> {
	private ActionStdV1<PayordemInfo> actionHelper;
	
	
	public StdPayordemInsert(DeciTreeOption<PayordemInfo> option) {
		DaoStmtExec_<PayordemInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PayordemInfo> buildStmtExec(DeciTreeOption<PayordemInfo> option) {
		List<DaoStmtExecOption<PayordemInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayordemInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayordemInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayordemInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayordemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
