package br.com.mind5.business.materialStock.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.dao.MatockLock;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatockLock implements ActionStdV1<MatockInfo> {
	private ActionStdV1<MatockInfo> actionHelper;
	
	
	public StdMatockLock(DeciTreeOption<MatockInfo> option) {
		DaoStmtExec_<MatockInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatockInfo> buildStmtExec(DeciTreeOption<MatockInfo> option) {
		List<DaoStmtExecOption<MatockInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatockInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatockInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatockLock(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatockInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatockInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
