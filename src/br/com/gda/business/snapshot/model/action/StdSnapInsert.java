package br.com.gda.business.snapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.snapshot.dao.SnapInsert;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSnapInsert implements ActionStd<SnapInfo> {
	private ActionStd<SnapInfo> actionHelper;
	
	
	public StdSnapInsert(DeciTreeOption<SnapInfo> option) {
		DaoStmtExec<SnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SnapInfo> buildStmtExec(DeciTreeOption<SnapInfo> option) {
		List<DaoStmtExecOption<SnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
