package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.dao.MatEmpUpdate;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionMatEmpUpdate implements ActionStd<MatEmpInfo> {
	ActionStd<MatEmpInfo> actionHelper;
	
	
	public ActionMatEmpUpdate(DeciTreeOption<MatEmpInfo> option) {
		DaoStmtExec<MatEmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatEmpInfo> buildStmtExec(DeciTreeOption<MatEmpInfo> option) {
		List<DaoStmtExecOption<MatEmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatEmpInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatEmpInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatEmpUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
