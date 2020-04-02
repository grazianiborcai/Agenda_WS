package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.MatUnitSelect;
import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatUnitSelect implements ActionStdV1<MatUnitInfo> {
	private ActionStdV1<MatUnitInfo> actionHelper;
	
	
	public StdMatUnitSelect(DeciTreeOption<MatUnitInfo> option) {
		DaoStmtExec_<MatUnitInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatUnitInfo> buildStmtExec(DeciTreeOption<MatUnitInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatUnitInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatUnitInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
