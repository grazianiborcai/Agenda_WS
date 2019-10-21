package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapSelect;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedinapSelect implements ActionStd<SchedinapInfo> {
	private ActionStd<SchedinapInfo> actionHelper;
	
	
	public StdSchedinapSelect(DeciTreeOption<SchedinapInfo> option) {
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
		
		return new SchedinapSelect(stmtExecOptions);
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
