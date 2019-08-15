package br.com.gda.business.customerSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerSnapshot.dao.CusnapSelect;
import br.com.gda.business.customerSnapshot.info.CusnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
