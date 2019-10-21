package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.MatGroupSelect;
import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
