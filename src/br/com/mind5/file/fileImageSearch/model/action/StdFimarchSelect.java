package br.com.mind5.file.fileImageSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.file.fileImageSearch.dao.FimarchSelect;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimarchSelect implements ActionStd<FimarchInfo> {
	private ActionStd<FimarchInfo> actionHelper;
	
	
	public StdFimarchSelect(DeciTreeOption<FimarchInfo> option) {
		DaoStmtExec<FimarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FimarchInfo> buildStmtExec(DeciTreeOption<FimarchInfo> option) {
		List<DaoStmtExecOption<FimarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FimarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FimarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FimarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FimarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FimarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
