package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatTypeSelect;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatTypeSelect implements ActionStd<MatTypeInfo> {
	private ActionStd<MatTypeInfo> actionHelper;
	
	
	public ActionMatTypeSelect(DeciTreeOption<MatTypeInfo> option) {
		DaoStmtExec<MatTypeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatTypeInfo> buildStmtExec(DeciTreeOption<MatTypeInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazy<MatTypeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatTypeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
