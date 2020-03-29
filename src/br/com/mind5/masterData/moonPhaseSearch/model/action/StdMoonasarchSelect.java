package br.com.mind5.masterData.moonPhaseSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.dao.MoonasarchSelect;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonasarchSelect implements ActionStd<MoonasarchInfo> {
	private ActionStd<MoonasarchInfo> actionHelper;
	
	
	public StdMoonasarchSelect(DeciTreeOption<MoonasarchInfo> option) {
		DaoStmtExec<MoonasarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MoonasarchInfo> buildStmtExec(DeciTreeOption<MoonasarchInfo> option) {
		List<DaoStmtExecOption<MoonasarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MoonasarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MoonasarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MoonasarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MoonasarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MoonasarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
