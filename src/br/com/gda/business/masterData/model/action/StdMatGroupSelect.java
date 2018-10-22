package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatGroupSelect;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatGroupSelect implements ActionStd<MatGroupInfo> {
	private ActionStd<MatGroupInfo> actionHelper;
	
	
	public StdMatGroupSelect(DeciTreeOption<MatGroupInfo> option) {
		DaoStmtExec<MatGroupInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatGroupInfo> buildStmtExec(DeciTreeOption<MatGroupInfo> option) {
		List<DaoStmtExecOption<MatGroupInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatGroupInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatGroupInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatGroupSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatGroupInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatGroupInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
