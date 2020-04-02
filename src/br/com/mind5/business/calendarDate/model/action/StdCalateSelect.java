package br.com.mind5.business.calendarDate.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.dao.CalateSelect;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalateSelect implements ActionStdV1<CalateInfo> {
	private ActionStdV1<CalateInfo> actionHelper;
	
	
	public StdCalateSelect(DeciTreeOption<CalateInfo> option) {
		DaoStmtExec_<CalateInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CalateInfo> buildStmtExec(DeciTreeOption<CalateInfo> option) {
		List<DaoStmtExecOption<CalateInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CalateInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CalateInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CalateSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CalateInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CalateInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
