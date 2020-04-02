package br.com.mind5.business.scheduleSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleSearch.dao.SchedarchSelect;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedarchSelect implements ActionStdV1<SchedarchInfo> {
	private ActionStdV1<SchedarchInfo> actionHelper;
	
	
	public StdSchedarchSelect(DeciTreeOption<SchedarchInfo> option) {
		DaoStmtExec_<SchedarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SchedarchInfo> buildStmtExec(DeciTreeOption<SchedarchInfo> option) {
		List<DaoStmtExecOption<SchedarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SchedarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
