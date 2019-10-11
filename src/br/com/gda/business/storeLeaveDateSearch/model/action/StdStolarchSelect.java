package br.com.gda.business.storeLeaveDateSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDateSearch.dao.StolarchSelect;
import br.com.gda.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStolarchSelect implements ActionStd<StolarchInfo> {
	private ActionStd<StolarchInfo> actionHelper;
	
	
	public StdStolarchSelect(DeciTreeOption<StolarchInfo> option) {
		DaoStmtExec<StolarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StolarchInfo> buildStmtExec(DeciTreeOption<StolarchInfo> option) {
		List<DaoStmtExecOption<StolarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
