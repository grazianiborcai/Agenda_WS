package br.com.mind5.business.company.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.dao.CompUpdate;
import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompUpdate implements ActionStdV1<CompInfo> {
	ActionStdV1<CompInfo> actionHelper;
	
	
	public StdCompUpdate(DeciTreeOption<CompInfo> option) {
		DaoStmtExec_<CompInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CompInfo> buildStmtExec(DeciTreeOption<CompInfo> option) {
		List<DaoStmtExecOption<CompInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CompInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CompInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CompUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CompInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
