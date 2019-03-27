package br.com.gda.business.material.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.dao.MatUpdate;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatUpdate implements ActionStd<MatInfo> {
	private ActionStd<MatInfo> actionHelper;
	
	
	public StdMatUpdate(DeciTreeOption<MatInfo> option) {
		DaoStmtExec<MatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatInfo> buildStmtExec(DeciTreeOption<MatInfo> option) {
		List<DaoStmtExecOption<MatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
