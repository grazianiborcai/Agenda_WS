package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.StateSelect;
import br.com.mind5.business.masterData.info.StateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStateSelect implements ActionStd<StateInfo> {
	private ActionStd<StateInfo> actionHelper;
	
	
	public StdStateSelect(DeciTreeOption<StateInfo> option) {
		DaoStmtExec<StateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StateInfo> buildStmtExec(DeciTreeOption<StateInfo> option) {
		List<DaoStmtExecOption<StateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StateSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
