package br.com.mind5.business.materialText.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.dao.MatextDelete;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextDelete implements ActionStd<MatextInfo> {
	private ActionStd<MatextInfo> actionHelper;
	
	
	public StdMatextDelete(DeciTreeOption<MatextInfo> option) {
		DaoStmtExec<MatextInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatextInfo> buildStmtExec(DeciTreeOption<MatextInfo> option) {
		List<DaoStmtExecOption<MatextInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatextInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatextInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatextDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
