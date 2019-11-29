package br.com.mind5.business.employeeMaterialSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterialSearch.dao.EmpmarchSelect;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpmarchSelect implements ActionStd<EmpmarchInfo> {
	private ActionStd<EmpmarchInfo> actionHelper;
	
	
	public StdEmpmarchSelect(DeciTreeOption<EmpmarchInfo> option) {
		DaoStmtExec<EmpmarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpmarchInfo> buildStmtExec(DeciTreeOption<EmpmarchInfo> option) {
		List<DaoStmtExecOption<EmpmarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpmarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpmarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpmarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpmarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpmarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
