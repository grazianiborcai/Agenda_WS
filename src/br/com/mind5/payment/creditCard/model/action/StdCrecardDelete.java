package br.com.mind5.payment.creditCard.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.dao.CrecardDelete;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class StdCrecardDelete implements ActionStdV1<CrecardInfo> {
	private ActionStdV1<CrecardInfo> actionHelper;
	
	
	public StdCrecardDelete(DeciTreeOption<CrecardInfo> option) {
		DaoStmtExec_<CrecardInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CrecardInfo> buildStmtExec(DeciTreeOption<CrecardInfo> option) {
		List<DaoStmtExecOption<CrecardInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CrecardInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CrecardInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CrecardDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CrecardInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CrecardInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
