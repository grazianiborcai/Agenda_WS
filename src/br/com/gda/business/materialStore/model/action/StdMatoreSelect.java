package br.com.gda.business.materialStore.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.dao.MatoreSelect;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatoreSelect implements ActionStd<MatoreInfo> {
	private ActionStd<MatoreInfo> actionHelper;
	
	
	public StdMatoreSelect(DeciTreeOption<MatoreInfo> option) {
		DaoStmtExec<MatoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatoreInfo> buildStmtExec(DeciTreeOption<MatoreInfo> option) {
		List<DaoStmtExecOption<MatoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatoreSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
