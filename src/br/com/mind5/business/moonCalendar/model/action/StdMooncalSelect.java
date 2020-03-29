package br.com.mind5.business.moonCalendar.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.dao.MooncalSelect;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMooncalSelect implements ActionStd<MooncalInfo> {
	private ActionStd<MooncalInfo> actionHelper;
	
	
	public StdMooncalSelect(DeciTreeOption<MooncalInfo> option) {
		DaoStmtExec<MooncalInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MooncalInfo> buildStmtExec(DeciTreeOption<MooncalInfo> option) {
		List<DaoStmtExecOption<MooncalInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MooncalInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MooncalInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MooncalSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MooncalInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MooncalInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
