package br.com.mind5.payment.creditCard.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.dao.CrecardSelect;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardSelect implements ActionStd<CrecardInfo> {
	private ActionStd<CrecardInfo> actionHelper;
	
	
	public StdCrecardSelect(DeciTreeOption<CrecardInfo> option) {
		DaoStmtExec<CrecardInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CrecardInfo> buildStmtExec(DeciTreeOption<CrecardInfo> option) {
		List<DaoStmtExecOption<CrecardInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CrecardInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CrecardInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CrecardSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CrecardInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CrecardInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
