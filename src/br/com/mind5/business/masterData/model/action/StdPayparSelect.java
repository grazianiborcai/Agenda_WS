package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.PayparSelect;
import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPayparSelect implements ActionStd<PayparInfo> {
	private ActionStd<PayparInfo> actionHelper;
	
	
	public StdPayparSelect(DeciTreeOption<PayparInfo> option) {
		DaoStmtExec_<PayparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PayparInfo> buildStmtExec(DeciTreeOption<PayparInfo> option) {
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
