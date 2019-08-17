package br.com.gda.business.scheduleLineSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLineSnapshot.dao.SchedinapInsert;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSchedinapInsert implements ActionStd<SchedinapInfo> {
	private ActionStd<SchedinapInfo> actionHelper;
	
	
	public StdSchedinapInsert(DeciTreeOption<SchedinapInfo> option) {
		DaoStmtExec<SchedinapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SchedinapInfo> buildStmtExec(DeciTreeOption<SchedinapInfo> option) {
		List<DaoStmtExecOption<SchedinapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedinapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedinapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedinapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SchedinapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedinapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
