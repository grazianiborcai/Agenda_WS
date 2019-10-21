package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.MatUnitSelect;
import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatUnitSelect implements ActionStd<MatUnitInfo> {
	private ActionStd<MatUnitInfo> actionHelper;
	
	
	public StdMatUnitSelect(DeciTreeOption<MatUnitInfo> option) {
		DaoStmtExec<MatUnitInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatUnitInfo> buildStmtExec(DeciTreeOption<MatUnitInfo> option) {
		List<DaoStmtExecOption<MatUnitInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatUnitInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatUnitInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatUnitSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatUnitInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatUnitInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
