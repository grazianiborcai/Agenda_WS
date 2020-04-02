package br.com.mind5.masterData.moonPhase.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.moonPhase.dao.MoonaseSelect;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonaseSelect implements ActionStdV1<MoonaseInfo> {
	private ActionStdV1<MoonaseInfo> actionHelper;
	
	
	public StdMoonaseSelect(DeciTreeOption<MoonaseInfo> option) {
		DaoStmtExec_<MoonaseInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MoonaseInfo> buildStmtExec(DeciTreeOption<MoonaseInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<MoonaseInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MoonaseInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
