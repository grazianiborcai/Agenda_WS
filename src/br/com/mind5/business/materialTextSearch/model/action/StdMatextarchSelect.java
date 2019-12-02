package br.com.mind5.business.materialTextSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSearch.dao.MatextarchSelect;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextarchSelect implements ActionStd<MatextarchInfo> {
	private ActionStd<MatextarchInfo> actionHelper;
	
	
	public StdMatextarchSelect(DeciTreeOption<MatextarchInfo> option) {
		DaoStmtExec<MatextarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatextarchInfo> buildStmtExec(DeciTreeOption<MatextarchInfo> option) {
		List<DaoStmtExecOption<MatextarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatextarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatextarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatextarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
