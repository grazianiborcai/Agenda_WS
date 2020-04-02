package br.com.mind5.business.employeePosition.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePosition.dao.EmposSelect;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposSelect implements ActionStd<EmposInfo> {
	private ActionStd<EmposInfo> actionHelper;
	
	
	public StdEmposSelect(DeciTreeOption<EmposInfo> option) {
		DaoStmtExec_<EmposInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmposInfo> buildStmtExec(DeciTreeOption<EmposInfo> option) {
		List<DaoStmtExecOption<EmposInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmposInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmposInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmposSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmposInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmposInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
