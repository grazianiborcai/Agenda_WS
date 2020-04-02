package br.com.mind5.business.personList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.dao.PersolisSelect;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersolisSelect implements ActionStdV1<PersolisInfo> {
	ActionStdV1<PersolisInfo> actionHelper;
	
	
	public StdPersolisSelect(DeciTreeOption<PersolisInfo> option) {
		DaoStmtExec_<PersolisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PersolisInfo> buildStmtExec(DeciTreeOption<PersolisInfo> option) {
		List<DaoStmtExecOption<PersolisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PersolisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PersolisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PersolisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PersolisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PersolisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
