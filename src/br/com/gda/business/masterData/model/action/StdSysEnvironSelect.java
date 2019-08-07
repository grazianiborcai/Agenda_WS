package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.SysEnvironSelect;
import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
