package br.com.mind5.business.order.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.dao.OrderUpdate;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderUpdate implements ActionStdV1<OrderInfo> {
	private ActionStdV1<OrderInfo> actionHelper;
	
	
	public StdOrderUpdate(DeciTreeOption<OrderInfo> option) {
		DaoStmtExec_<OrderInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrderInfo> buildStmtExec(DeciTreeOption<OrderInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<OrderInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
