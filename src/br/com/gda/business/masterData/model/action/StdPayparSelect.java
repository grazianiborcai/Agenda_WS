package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.PayparSelect;
import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPayparSelect implements ActionStd<PayparInfo> {
	private ActionStd<PayparInfo> actionHelper;
	
	
	public StdPayparSelect(DeciTreeOption<PayparInfo> option) {
		DaoStmtExec<PayparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayparInfo> buildStmtExec(DeciTreeOption<PayparInfo> option) {
		List<DaoStmtExecOption<PayparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayparSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
