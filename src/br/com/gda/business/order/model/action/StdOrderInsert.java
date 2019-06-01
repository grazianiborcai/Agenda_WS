package br.com.gda.business.order.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.dao.OrderInsert;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrderInsert implements ActionStd<OrderInfo> {
	private ActionStd<OrderInfo> actionHelper;
	
	
	public StdOrderInsert(DeciTreeOption<OrderInfo> option) {
		DaoStmtExec<OrderInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OrderInfo> buildStmtExec(DeciTreeOption<OrderInfo> option) {
		List<DaoStmtExecOption<OrderInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrderInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrderInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrderInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrderInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
