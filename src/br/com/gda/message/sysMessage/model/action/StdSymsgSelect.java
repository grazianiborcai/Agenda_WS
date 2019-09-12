package br.com.gda.message.sysMessage.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.message.sysMessage.dao.SymsgSelect;
import br.com.gda.message.sysMessage.info.SymsgInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSymsgSelect implements ActionStd<SymsgInfo> {
	private ActionStd<SymsgInfo> actionHelper;
	
	
	public StdSymsgSelect(DeciTreeOption<SymsgInfo> option) {
		DaoStmtExec<SymsgInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SymsgInfo> buildStmtExec(DeciTreeOption<SymsgInfo> option) {
		List<DaoStmtExecOption<SymsgInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SymsgInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SymsgInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SymsgSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SymsgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SymsgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
