package br.com.gda.business.customerList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerList.dao.CuslisSelect;
import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCuslisSelect implements ActionStd<CuslisInfo> {
	private ActionStd<CuslisInfo> actionHelper;
	
	
	public StdCuslisSelect(DeciTreeOption<CuslisInfo> option) {
		DaoStmtExec<CuslisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CuslisInfo> buildStmtExec(DeciTreeOption<CuslisInfo> option) {
		List<DaoStmtExecOption<CuslisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CuslisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CuslisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CuslisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CuslisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CuslisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
