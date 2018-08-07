package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.dao.MatEmpSelect;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatEmpSelect implements DeciAction<MatEmpInfo> {
	private DeciAction<MatEmpInfo> actionHelper;
	
	
	public ActionMatEmpSelect(DeciTreeOption<MatEmpInfo> option) {
		DaoStmtExec<MatEmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
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
		
		return new MatEmpSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
