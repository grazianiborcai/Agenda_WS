package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.MatTypeSelect;
import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatTypeSelect implements ActionStdV1<MatTypeInfo> {
	private ActionStdV1<MatTypeInfo> actionHelper;
	
	
	public StdMatTypeSelect(DeciTreeOption<MatTypeInfo> option) {
		DaoStmtExec_<MatTypeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatTypeInfo> buildStmtExec(DeciTreeOption<MatTypeInfo> option) {
		List<DaoStmtExecOption<MatTypeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatTypeInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatTypeInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatTypeSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatTypeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatTypeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
