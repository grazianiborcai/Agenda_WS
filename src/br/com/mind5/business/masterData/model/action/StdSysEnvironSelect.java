package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.SysEnvironSelect;
import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysEnvironSelect implements ActionStd<SysEnvironInfo> {
	private ActionStd<SysEnvironInfo> actionHelper;
	
	
	public StdSysEnvironSelect(DeciTreeOption<SysEnvironInfo> option) {
		DaoStmtExec<SysEnvironInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SysEnvironInfo> buildStmtExec(DeciTreeOption<SysEnvironInfo> option) {
		List<DaoStmtExecOption<SysEnvironInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SysEnvironInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SysEnvironInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SysEnvironSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SysEnvironInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SysEnvironInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
