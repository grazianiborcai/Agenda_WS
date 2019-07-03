package br.com.gda.payment.payOrderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.payOrderItem.dao.OrderemSelect;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class StdOrderemSelect implements ActionStd<PayordemInfo> {
	private ActionStd<PayordemInfo> actionHelper;
	
	
	public StdOrderemSelect(DeciTreeOption<PayordemInfo> option) {
		DaoStmtExec<PayordemInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayordemInfo> buildStmtExec(DeciTreeOption<PayordemInfo> option) {
		List<DaoStmtExecOption<PayordemInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayordemInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayordemInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrderemSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
