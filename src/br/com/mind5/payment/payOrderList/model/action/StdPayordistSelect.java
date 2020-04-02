package br.com.mind5.payment.payOrderList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.dao.PayordistSelect;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class StdPayordistSelect implements ActionStdV1<PayordistInfo> {
	private ActionStdV1<PayordistInfo> actionHelper;
	
	
	public StdPayordistSelect(DeciTreeOption<PayordistInfo> option) {
		DaoStmtExec_<PayordistInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PayordistInfo> buildStmtExec(DeciTreeOption<PayordistInfo> option) {
		List<DaoStmtExecOption<PayordistInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayordistInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayordistInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayordistSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayordistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
