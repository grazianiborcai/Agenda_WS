package br.com.gda.business.materialText.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialText.dao.MatextUpdate;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatextUpdate implements ActionStd<MatextInfo> {
	private ActionStd<MatextInfo> actionHelper;	
	
	
	public StdMatextUpdate(DeciTreeOption<MatextInfo> option) {
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
		
		return new MatextUpdate(stmtExecOptions);
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
