package br.com.gda.business.orderReserve.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderReserve.dao.OrderveSelect;
import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrderveSelect implements ActionStd<OrderveInfo> {
	private ActionStd<OrderveInfo> actionHelper;
	
	
	public StdOrderveSelect(DeciTreeOption<OrderveInfo> option) {
		DaoStmtExec<OrderveInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OrderveInfo> buildStmtExec(DeciTreeOption<OrderveInfo> option) {
		List<DaoStmtExecOption<OrderveInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrderveInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrderveInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrderveSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrderveInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderveInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
