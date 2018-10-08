package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.dao.MatStoreUpdate;
import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionMatStoreUpdate implements ActionStd<MatStoreInfo> {
	ActionStd<MatStoreInfo> actionHelper;
	
	
	public ActionMatStoreUpdate(DeciTreeOption<MatStoreInfo> option) {
		DaoStmtExec<MatStoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatStoreInfo> buildStmtExec(DeciTreeOption<MatStoreInfo> option) {
		List<DaoStmtExecOption<MatStoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatStoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatStoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatStoreUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
