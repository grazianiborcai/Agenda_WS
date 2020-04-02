package br.com.mind5.business.storeLeaveDateSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.dao.StolarchSelect;
import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolarchSelect implements ActionStdV1<StolarchInfo> {
	private ActionStdV1<StolarchInfo> actionHelper;
	
	
	public StdStolarchSelect(DeciTreeOption<StolarchInfo> option) {
		DaoStmtExec_<StolarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StolarchInfo> buildStmtExec(DeciTreeOption<StolarchInfo> option) {
		List<DaoStmtExecOption<StolarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StolarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
