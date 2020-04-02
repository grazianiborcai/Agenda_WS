package br.com.mind5.business.personSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.dao.PersonapSelect;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonapSelect implements ActionStdV1<PersonapInfo> {
	ActionStdV1<PersonapInfo> actionHelper;
	
	
	public StdPersonapSelect(DeciTreeOption<PersonapInfo> option) {
		DaoStmtExec_<PersonapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PersonapInfo> buildStmtExec(DeciTreeOption<PersonapInfo> option) {
		List<DaoStmtExecOption<PersonapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PersonapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PersonapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PersonapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PersonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
