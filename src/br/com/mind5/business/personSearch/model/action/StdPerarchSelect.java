package br.com.mind5.business.personSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.dao.PerarchSelect;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchSelect implements ActionStdV1<PerarchInfo> {
	ActionStdV1<PerarchInfo> actionHelper;
	
	
	public StdPerarchSelect(DeciTreeOption<PerarchInfo> option) {
		DaoStmtExec_<PerarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PerarchInfo> buildStmtExec(DeciTreeOption<PerarchInfo> option) {
		List<DaoStmtExecOption<PerarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PerarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PerarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PerarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PerarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PerarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
