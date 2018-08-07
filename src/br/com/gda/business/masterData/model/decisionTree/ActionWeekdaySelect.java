package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.WeekdaySelect;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionWeekdaySelect implements DeciAction<WeekdayInfo> {
	private DeciAction<WeekdayInfo> actionHelper;
	
	
	public ActionWeekdaySelect(DeciTreeOption<WeekdayInfo> option) {
		DaoStmtExec<WeekdayInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<WeekdayInfo> buildStmtExec(DeciTreeOption<WeekdayInfo> option) {
		List<DaoStmtExecOption<WeekdayInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(WeekdayInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<WeekdayInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new WeekdaySelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<WeekdayInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WeekdayInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
