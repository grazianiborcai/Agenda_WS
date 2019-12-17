package br.com.mind5.business.materialStockSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStockSearch.dao.MatocarchSelect;
import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatocarchSelect implements ActionStd<MatocarchInfo> {
	private ActionStd<MatocarchInfo> actionHelper;
	
	
	public StdMatocarchSelect(DeciTreeOption<MatocarchInfo> option) {
		DaoStmtExec<MatocarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatocarchInfo> buildStmtExec(DeciTreeOption<MatocarchInfo> option) {
		List<DaoStmtExecOption<MatocarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatocarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatocarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatocarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatocarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatocarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
