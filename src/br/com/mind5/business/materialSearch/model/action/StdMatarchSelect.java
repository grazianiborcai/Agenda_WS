package br.com.mind5.business.materialSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.dao.MatarchSelect;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatarchSelect implements ActionStd<MatarchInfo> {
	private ActionStd<MatarchInfo> actionHelper;
	
	
	public StdMatarchSelect(DeciTreeOption<MatarchInfo> option) {
		DaoStmtExec_<MatarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatarchInfo> buildStmtExec(DeciTreeOption<MatarchInfo> option) {
		List<DaoStmtExecOption<MatarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
