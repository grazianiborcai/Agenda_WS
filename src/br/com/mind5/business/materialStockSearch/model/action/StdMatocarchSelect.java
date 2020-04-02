package br.com.mind5.business.materialStockSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStockSearch.dao.MatocarchSelect;
import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatocarchSelect implements ActionStdV1<MatocarchInfo> {
	private ActionStdV1<MatocarchInfo> actionHelper;
	
	
	public StdMatocarchSelect(DeciTreeOption<MatocarchInfo> option) {
		DaoStmtExec_<MatocarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatocarchInfo> buildStmtExec(DeciTreeOption<MatocarchInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatocarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatocarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
