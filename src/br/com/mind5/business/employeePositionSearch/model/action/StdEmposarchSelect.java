package br.com.mind5.business.employeePositionSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.dao.EmposarchSelect;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposarchSelect implements ActionStdV1<EmposarchInfo> {
	private ActionStdV1<EmposarchInfo> actionHelper;
	
	
	public StdEmposarchSelect(DeciTreeOption<EmposarchInfo> option) {
		DaoStmtExec_<EmposarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EmposarchInfo> buildStmtExec(DeciTreeOption<EmposarchInfo> option) {
		List<DaoStmtExecOption<EmposarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmposarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmposarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmposarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<EmposarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmposarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
