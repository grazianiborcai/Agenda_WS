package br.com.mind5.business.materialStock.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.dao.MatockSelect;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatockSelect implements ActionStd<MatockInfo> {
	private ActionStd<MatockInfo> actionHelper;
	
	
	public StdMatockSelect(DeciTreeOption<MatockInfo> option) {
		DaoStmtExec<MatockInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatockInfo> buildStmtExec(DeciTreeOption<MatockInfo> option) {
		List<DaoStmtExecOption<MatockInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatockInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatockInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatockSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatockInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatockInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
