package br.com.mind5.payment.payOrderSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.dao.PayordarchSelect;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class StdPayordarchSelect implements ActionStdV1<PayordarchInfo> {
	private ActionStdV1<PayordarchInfo> actionHelper;
	
	
	public StdPayordarchSelect(DeciTreeOption<PayordarchInfo> option) {
		DaoStmtExec_<PayordarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PayordarchInfo> buildStmtExec(DeciTreeOption<PayordarchInfo> option) {
		List<DaoStmtExecOption<PayordarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayordarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayordarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayordarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayordarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
