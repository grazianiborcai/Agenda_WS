package br.com.gda.file.fileUpload.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.fileUpload.dao.FilupDelete;
import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFilupDelete implements ActionStd<FilupInfo> {
	private ActionStd<FilupInfo> actionHelper;
	
	
	public StdFilupDelete(DeciTreeOption<FilupInfo> option) {
		DaoStmtExec<FilupInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FilupInfo> buildStmtExec(DeciTreeOption<FilupInfo> option) {
		List<DaoStmtExecOption<FilupInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FilupInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FilupInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FilupDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FilupInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FilupInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
