package br.com.mind5.business.employeeLeaveDateRange.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.dao.EmplargSelect;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplargSelect implements ActionStdV1<EmplargInfo> {
	ActionStdV1<EmplargInfo> actionHelper;
	
	
	public StdEmplargSelect(DeciTreeOption<EmplargInfo> option) {
		DaoStmtExec_<EmplargInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmplargInfo> buildStmtExec(DeciTreeOption<EmplargInfo> option) {
		List<DaoStmtExecOption<EmplargInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmplargInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmplargInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmplargSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmplargInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmplargInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}

