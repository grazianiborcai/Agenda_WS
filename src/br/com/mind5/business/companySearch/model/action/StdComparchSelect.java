package br.com.mind5.business.companySearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySearch.dao.ComparchSelect;
import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdComparchSelect implements ActionStd<ComparchInfo> {
	ActionStd<ComparchInfo> actionHelper;
	
	
	public StdComparchSelect(DeciTreeOption<ComparchInfo> option) {
		DaoStmtExec<ComparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<ComparchInfo> buildStmtExec(DeciTreeOption<ComparchInfo> option) {
		List<DaoStmtExecOption<ComparchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(ComparchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<ComparchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new ComparchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ComparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ComparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
