package br.com.mind5.payment.storePartnerList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.dao.StoplisSelect;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StdStoplisSelect implements ActionStdV1<StoplisInfo> {
	private ActionStdV1<StoplisInfo> actionHelper;
	
	
	public StdStoplisSelect(DeciTreeOption<StoplisInfo> option) {
		DaoStmtExec_<StoplisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StoplisInfo> buildStmtExec(DeciTreeOption<StoplisInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<StoplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
