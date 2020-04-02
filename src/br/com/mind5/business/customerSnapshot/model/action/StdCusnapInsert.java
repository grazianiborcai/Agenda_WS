package br.com.mind5.business.customerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.dao.CusnapInsert;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusnapInsert implements ActionStdV1<CusnapInfo> {
	private ActionStdV1<CusnapInfo> actionHelper;
	
	
	public StdCusnapInsert(DeciTreeOption<CusnapInfo> option) {
		DaoStmtExec_<CusnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CusnapInfo> buildStmtExec(DeciTreeOption<CusnapInfo> option) {
		List<DaoStmtExecOption<CusnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CusnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
