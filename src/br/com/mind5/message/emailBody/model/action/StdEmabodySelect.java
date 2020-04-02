package br.com.mind5.message.emailBody.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.message.emailBody.dao.EmabodySelect;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmabodySelect implements ActionStdV1<EmabodyInfo> {
	private ActionStdV1<EmabodyInfo> actionHelper;
	
	
	public StdEmabodySelect(DeciTreeOption<EmabodyInfo> option) {
		DaoStmtExec_<EmabodyInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmabodyInfo> buildStmtExec(DeciTreeOption<EmabodyInfo> option) {
		List<DaoStmtExecOption<EmabodyInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmabodyInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmabodyInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmabodySelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmabodyInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmabodyInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
