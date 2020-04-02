package br.com.mind5.business.customerList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.dao.CuslisSelect;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCuslisSelect implements ActionStdV1<CuslisInfo> {
	private ActionStdV1<CuslisInfo> actionHelper;
	
	
	public StdCuslisSelect(DeciTreeOption<CuslisInfo> option) {
		DaoStmtExec_<CuslisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CuslisInfo> buildStmtExec(DeciTreeOption<CuslisInfo> option) {
		List<DaoStmtExecOption<CuslisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CuslisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CuslisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CuslisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CuslisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CuslisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
