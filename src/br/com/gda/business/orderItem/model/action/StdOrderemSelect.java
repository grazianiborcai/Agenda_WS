package br.com.gda.business.orderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.dao.OrderemSelect;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrderemSelect implements ActionStd<OrderemInfo> {
	private ActionStd<OrderemInfo> actionHelper;
	
	
	public StdOrderemSelect(DeciTreeOption<OrderemInfo> option) {
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
		
		return new OrderemSelect(stmtExecOptions);
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
