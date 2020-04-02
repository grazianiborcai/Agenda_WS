package br.com.mind5.file.filePath.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.file.filePath.dao.FathSelect;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFathSelect implements ActionStd<FathInfo> {
	private ActionStd<FathInfo> actionHelper;
	
	
	public StdFathSelect(DeciTreeOption<FathInfo> option) {
		DaoStmtExec_<FathInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<FathInfo> buildStmtExec(DeciTreeOption<FathInfo> option) {
		List<DaoStmtExecOption<FathInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FathInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FathInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FathSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FathInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FathInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
