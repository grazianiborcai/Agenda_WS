package br.com.mind5.business.materialTextDefault.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.dao.MatextaultSelect;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultSelect implements ActionStd<MatextaultInfo> {
	private ActionStd<MatextaultInfo> actionHelper;
	
	
	public StdMatextaultSelect(DeciTreeOption<MatextaultInfo> option) {
		DaoStmtExec<MatextaultInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatextaultInfo> buildStmtExec(DeciTreeOption<MatextaultInfo> option) {
		List<DaoStmtExecOption<MatextaultInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatextaultInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatextaultInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatextaultSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextaultInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextaultInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
