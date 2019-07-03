package br.com.gda.payment.systemPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.systemPartner.dao.SysparSelect;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class StdSysparSelect implements ActionStd<SysparInfo> {
	private ActionStd<SysparInfo> actionHelper;
	
	
	public StdSysparSelect(DeciTreeOption<SysparInfo> option) {
		DaoStmtExec<SysparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SysparInfo> buildStmtExec(DeciTreeOption<SysparInfo> option) {
		List<DaoStmtExecOption<SysparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SysparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SysparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SysparSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SysparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SysparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
