package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.SysEnvironSelect;
import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSysEnvironSelect implements ActionStdV1<SysEnvironInfo> {
	private ActionStdV1<SysEnvironInfo> actionHelper;
	
	
	public StdSysEnvironSelect(DeciTreeOption<SysEnvironInfo> option) {
		DaoStmtExec_<SysEnvironInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SysEnvironInfo> buildStmtExec(DeciTreeOption<SysEnvironInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<SysEnvironInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SysEnvironInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
