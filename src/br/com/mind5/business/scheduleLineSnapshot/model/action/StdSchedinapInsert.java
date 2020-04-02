package br.com.mind5.business.scheduleLineSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapInsert;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedinapInsert implements ActionStdV1<SchedinapInfo> {
	private ActionStdV1<SchedinapInfo> actionHelper;
	
	
	public StdSchedinapInsert(DeciTreeOption<SchedinapInfo> option) {
		DaoStmtExec_<SchedinapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SchedinapInfo> buildStmtExec(DeciTreeOption<SchedinapInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<SchedinapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedinapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
