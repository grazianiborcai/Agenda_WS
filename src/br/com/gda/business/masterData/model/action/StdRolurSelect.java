package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.RolurSelect;
import br.com.gda.business.masterData.info.RolurInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdRolurSelect implements ActionStd<RolurInfo> {
	private ActionStd<RolurInfo> actionHelper;
	
	
	public StdRolurSelect(DeciTreeOption<RolurInfo> option) {
		DaoStmtExec<RolurInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<RolurInfo> buildStmtExec(DeciTreeOption<RolurInfo> option) {
		List<DaoStmtExecOption<RolurInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(RolurInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<RolurInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new RolurSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<RolurInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<RolurInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
