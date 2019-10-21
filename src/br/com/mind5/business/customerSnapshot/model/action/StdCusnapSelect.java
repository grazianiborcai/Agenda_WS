package br.com.mind5.business.customerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.dao.CusnapSelect;
import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusnapSelect implements ActionStd<CusnapInfo> {
	private ActionStd<CusnapInfo> actionHelper;
	
	
	public StdCusnapSelect(DeciTreeOption<CusnapInfo> option) {
		DaoStmtExec<CusnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CusnapInfo> buildStmtExec(DeciTreeOption<CusnapInfo> option) {
		List<DaoStmtExecOption<CusnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusnapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
