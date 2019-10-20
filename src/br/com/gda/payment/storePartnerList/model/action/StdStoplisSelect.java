package br.com.gda.payment.storePartnerList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.storePartnerList.dao.StoplisSelect;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;

public final class StdStoplisSelect implements ActionStd<StoplisInfo> {
	private ActionStd<StoplisInfo> actionHelper;
	
	
	public StdStoplisSelect(DeciTreeOption<StoplisInfo> option) {
		DaoStmtExec<StoplisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoplisInfo> buildStmtExec(DeciTreeOption<StoplisInfo> option) {
		List<DaoStmtExecOption<StoplisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoplisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoplisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoplisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
