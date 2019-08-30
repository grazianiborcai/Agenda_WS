package br.com.gda.payment.payOrderSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderSearch.dao.PayordarchSelect;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;

public final class StdPayordarchSelect implements ActionStd<PayordarchInfo> {
	private ActionStd<PayordarchInfo> actionHelper;
	
	
	public StdPayordarchSelect(DeciTreeOption<PayordarchInfo> option) {
		DaoStmtExec<PayordarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayordarchInfo> buildStmtExec(DeciTreeOption<PayordarchInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazy<PayordarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
