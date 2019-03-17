package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatmovTypeSelect;
import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatmovTypeSelect implements ActionStd<MatmovTypeInfo> {
	private ActionStd<MatmovTypeInfo> actionHelper;
	
	
	public StdMatmovTypeSelect(DeciTreeOption<MatmovTypeInfo> option) {
		DaoStmtExec<MatmovTypeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatmovTypeInfo> buildStmtExec(DeciTreeOption<MatmovTypeInfo> option) {
		List<DaoStmtExecOption<MatmovTypeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatmovTypeInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatmovTypeInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatmovTypeSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatmovTypeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmovTypeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
