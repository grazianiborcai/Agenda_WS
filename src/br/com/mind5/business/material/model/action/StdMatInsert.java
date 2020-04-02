package br.com.mind5.business.material.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.dao.MatInsert;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatInsert implements ActionStdV1<MatInfo> {
	private ActionStdV1<MatInfo> actionHelper;
	
	
	public StdMatInsert(DeciTreeOption<MatInfo> option) {
		DaoStmtExec_<MatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatInfo> buildStmtExec(DeciTreeOption<MatInfo> option) {
		List<DaoStmtExecOption<MatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
