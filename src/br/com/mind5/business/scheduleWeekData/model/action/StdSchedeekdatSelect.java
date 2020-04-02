package br.com.mind5.business.scheduleWeekData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.dao.SchedeekdatSelect;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedeekdatSelect implements ActionStdV1<SchedeekdatInfo> {
	private ActionStdV1<SchedeekdatInfo> actionHelper;
	
	
	public StdSchedeekdatSelect(DeciTreeOption<SchedeekdatInfo> option) {
		DaoStmtExec_<SchedeekdatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SchedeekdatInfo> buildStmtExec(DeciTreeOption<SchedeekdatInfo> option) {
		List<DaoStmtExecOption<SchedeekdatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SchedeekdatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SchedeekdatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SchedeekdatSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SchedeekdatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SchedeekdatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
