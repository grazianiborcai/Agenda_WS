package br.com.mind5.business.companySnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.dao.CompnapInsert;
import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompnapInsert implements ActionStdV1<CompnapInfo> {
	ActionStdV1<CompnapInfo> actionHelper;
	
	
	public StdCompnapInsert(DeciTreeOption<CompnapInfo> option) {
		DaoStmtExec_<CompnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CompnapInfo> buildStmtExec(DeciTreeOption<CompnapInfo> option) {
		List<DaoStmtExecOption<CompnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CompnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CompnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CompnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CompnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
