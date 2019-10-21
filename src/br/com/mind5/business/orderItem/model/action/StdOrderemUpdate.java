package br.com.mind5.business.orderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.dao.OrderemUpdate;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderemUpdate implements ActionStd<OrderemInfo> {
	private ActionStd<OrderemInfo> actionHelper;
	
	
	public StdOrderemUpdate(DeciTreeOption<OrderemInfo> option) {
		DaoStmtExec<OrderemInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OrderemInfo> buildStmtExec(DeciTreeOption<OrderemInfo> option) {
		List<DaoStmtExecOption<OrderemInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrderemInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrderemInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrderemUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrderemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
