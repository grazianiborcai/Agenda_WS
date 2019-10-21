package br.com.mind5.business.order.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.dao.OrderUpdate;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderUpdate implements ActionStd<OrderInfo> {
	private ActionStd<OrderInfo> actionHelper;
	
	
	public StdOrderUpdate(DeciTreeOption<OrderInfo> option) {
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
		
		return new OrderUpdate(stmtExecOptions);
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
