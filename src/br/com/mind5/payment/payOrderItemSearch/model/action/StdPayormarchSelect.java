package br.com.mind5.payment.payOrderItemSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.dao.PayormarchSelect;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class StdPayormarchSelect implements ActionStd<PayormarchInfo> {
	private ActionStd<PayormarchInfo> actionHelper;
	
	
	public StdPayormarchSelect(DeciTreeOption<PayormarchInfo> option) {
		DaoStmtExec_<PayormarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PayormarchInfo> buildStmtExec(DeciTreeOption<PayormarchInfo> option) {
		List<DaoStmtExecOption<PayormarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayormarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayormarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayormarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayormarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayormarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
