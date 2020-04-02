package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.OrderStatusSelect;
import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderStatusSelect implements ActionStdV1<OrderStatusInfo> {
	private ActionStdV1<OrderStatusInfo> actionHelper;
	
	
	public StdOrderStatusSelect(DeciTreeOption<OrderStatusInfo> option) {
		DaoStmtExec_<OrderStatusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrderStatusInfo> buildStmtExec(DeciTreeOption<OrderStatusInfo> option) {
		List<DaoStmtExecOption<OrderStatusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrderStatusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrderStatusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrderStatusSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OrderStatusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderStatusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
