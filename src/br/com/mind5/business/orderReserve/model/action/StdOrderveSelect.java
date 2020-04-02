package br.com.mind5.business.orderReserve.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderReserve.dao.OrderveSelect;
import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderveSelect implements ActionStd<OrderveInfo> {
	private ActionStd<OrderveInfo> actionHelper;
	
	
	public StdOrderveSelect(DeciTreeOption<OrderveInfo> option) {
		DaoStmtExec_<OrderveInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrderveInfo> buildStmtExec(DeciTreeOption<OrderveInfo> option) {
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
