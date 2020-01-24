package br.com.mind5.business.companyConflict.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyConflict.dao.CompcoSelect;
import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompcoSelect implements ActionStd<CompcoInfo> {
	ActionStd<CompcoInfo> actionHelper;
	
	
	public StdCompcoSelect(DeciTreeOption<CompcoInfo> option) {
		DaoStmtExec<CompcoInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CompcoInfo> buildStmtExec(DeciTreeOption<CompcoInfo> option) {
		List<DaoStmtExecOption<CompcoInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CompcoInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CompcoInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CompcoSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CompcoInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CompcoInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
