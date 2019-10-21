package br.com.mind5.file.fileImage.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.file.fileImage.dao.FimgSelect;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgSelect implements ActionStd<FimgInfo> {
	private ActionStd<FimgInfo> actionHelper;
	
	
	public StdFimgSelect(DeciTreeOption<FimgInfo> option) {
		DaoStmtExec<FimgInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FimgInfo> buildStmtExec(DeciTreeOption<FimgInfo> option) {
		List<DaoStmtExecOption<FimgInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FimgInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FimgInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FimgSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FimgInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FimgInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
