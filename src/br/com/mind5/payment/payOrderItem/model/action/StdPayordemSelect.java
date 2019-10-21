package br.com.mind5.payment.payOrderItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.dao.PayordemSelect;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemSelect implements ActionStd<PayordemInfo> {
	private ActionStd<PayordemInfo> actionHelper;
	
	
	public StdPayordemSelect(DeciTreeOption<PayordemInfo> option) {
		DaoStmtExec<PayordemInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayordemInfo> buildStmtExec(DeciTreeOption<PayordemInfo> option) {
		List<DaoStmtExecOption<PayordemInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayordemInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayordemInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayordemSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayordemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
