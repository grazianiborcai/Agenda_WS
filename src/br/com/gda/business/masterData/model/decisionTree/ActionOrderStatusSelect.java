package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.OrderStatusSelect;
import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionOrderStatusSelect implements DeciAction<OrderStatusInfo> {
	private DeciAction<OrderStatusInfo> actionHelper;
	
	
	public ActionOrderStatusSelect(DeciTreeOption<OrderStatusInfo> option) {
		DaoStmtExec<OrderStatusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OrderStatusInfo> buildStmtExec(DeciTreeOption<OrderStatusInfo> option) {
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
	
	
	
	@Override public void addPostAction(DeciActionHandler<OrderStatusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrderStatusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
