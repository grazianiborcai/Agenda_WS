package br.com.mind5.payment.payOrderItemList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.dao.PayordemistSelect;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class StdPayordemistSelect implements ActionStdV1<PayordemistInfo> {
	private ActionStdV1<PayordemistInfo> actionHelper;
	
	
	public StdPayordemistSelect(DeciTreeOption<PayordemistInfo> option) {
		DaoStmtExec_<PayordemistInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PayordemistInfo> buildStmtExec(DeciTreeOption<PayordemistInfo> option) {
		List<DaoStmtExecOption<PayordemistInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayordemistInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayordemistInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayordemistSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PayordemistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayordemistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
