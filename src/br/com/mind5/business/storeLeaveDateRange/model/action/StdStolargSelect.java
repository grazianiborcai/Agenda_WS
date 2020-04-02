package br.com.mind5.business.storeLeaveDateRange.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.dao.StolargSelect;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolargSelect implements ActionStdV1<StolargInfo> {
	ActionStdV1<StolargInfo> actionHelper;
	
	
	public StdStolargSelect(DeciTreeOption<StolargInfo> option) {
		DaoStmtExec_<StolargInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StolargInfo> buildStmtExec(DeciTreeOption<StolargInfo> option) {
		List<DaoStmtExecOption<StolargInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolargInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolargInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolargSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StolargInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolargInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}

