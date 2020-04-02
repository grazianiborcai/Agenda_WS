package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.DaypartSelect;
import br.com.mind5.business.masterData.info.DaypartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDaypartSelect implements ActionStdV1<DaypartInfo> {
	private ActionStdV1<DaypartInfo> actionHelper;
	
	
	public StdDaypartSelect(DeciTreeOption<DaypartInfo> option) {
		DaoStmtExec_<DaypartInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<DaypartInfo> buildStmtExec(DeciTreeOption<DaypartInfo> option) {
		List<DaoStmtExecOption<DaypartInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(DaypartInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<DaypartInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new DaypartSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<DaypartInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<DaypartInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
