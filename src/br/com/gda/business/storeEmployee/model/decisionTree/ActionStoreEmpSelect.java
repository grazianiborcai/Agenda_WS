package br.com.gda.business.storeEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.dao.StoreEmpSelect;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionStoreEmpSelect implements ActionStd<StoreEmpInfo> {
	private ActionStd<StoreEmpInfo> actionHelper;
	
	
	public ActionStoreEmpSelect(DeciTreeOption<StoreEmpInfo> option) {
		DaoStmtExec<StoreEmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StoreEmpInfo> buildStmtExec(DeciTreeOption<StoreEmpInfo> option) {
		List<DaoStmtExecOption<StoreEmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreEmpInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoreEmpInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreEmpSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StoreEmpInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
