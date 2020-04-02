package br.com.mind5.file.fileImageList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.file.fileImageList.dao.FimistSelect;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimistSelect implements ActionStdV1<FimistInfo> {
	private ActionStdV1<FimistInfo> actionHelper;
	
	
	public StdFimistSelect(DeciTreeOption<FimistInfo> option) {
		DaoStmtExec_<FimistInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<FimistInfo> buildStmtExec(DeciTreeOption<FimistInfo> option) {
		List<DaoStmtExecOption<FimistInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FimistInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FimistInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FimistSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<FimistInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FimistInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
