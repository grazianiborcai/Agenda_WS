package br.com.mind5.masterData.moonPhase.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhase.dao.MoonaseSelect;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonaseSelect implements ActionStd<MoonaseInfo> {
	private ActionStd<MoonaseInfo> actionHelper;
	
	
	public StdMoonaseSelect(DeciTreeOption<MoonaseInfo> option) {
		DaoStmtExec<MoonaseInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MoonaseInfo> buildStmtExec(DeciTreeOption<MoonaseInfo> option) {
		List<DaoStmtExecOption<MoonaseInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MoonaseInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MoonaseInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MoonaseSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MoonaseInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MoonaseInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
