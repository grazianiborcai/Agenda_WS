package br.com.mind5.business.orderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.dao.OrderemInsert;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderemInsert implements ActionStdV1<OrderemInfo> {
	private ActionStdV1<OrderemInfo> actionHelper;
	
	
	public StdOrderemInsert(DeciTreeOption<OrderemInfo> option) {
		DaoStmtExec_<OrderemInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrderemInfo> buildStmtExec(DeciTreeOption<OrderemInfo> option) {
		List<DaoStmtExecOption<OrderemInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrderemInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrderemInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrderemInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OrderemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
