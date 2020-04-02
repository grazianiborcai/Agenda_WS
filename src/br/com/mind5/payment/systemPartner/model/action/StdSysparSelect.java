package br.com.mind5.payment.systemPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartner.dao.SysparSelect;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class StdSysparSelect implements ActionStd<SysparInfo> {
	private ActionStd<SysparInfo> actionHelper;
	
	
	public StdSysparSelect(DeciTreeOption<SysparInfo> option) {
		DaoStmtExec_<SysparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SysparInfo> buildStmtExec(DeciTreeOption<SysparInfo> option) {
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
