package br.com.mind5.masterData.moonPhaseSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.dao.MoonasarchSelect;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonasarchSelect implements ActionStdV1<MoonasarchInfo> {
	private ActionStdV1<MoonasarchInfo> actionHelper;
	
	
	public StdMoonasarchSelect(DeciTreeOption<MoonasarchInfo> option) {
		DaoStmtExec_<MoonasarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MoonasarchInfo> buildStmtExec(DeciTreeOption<MoonasarchInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<MoonasarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MoonasarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
