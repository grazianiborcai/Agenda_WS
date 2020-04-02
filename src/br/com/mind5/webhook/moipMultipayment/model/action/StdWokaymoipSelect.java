package br.com.mind5.webhook.moipMultipayment.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.dao.WokaymoipSelect;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipSelect implements ActionStdV1<WokaymoipInfo> {
	private ActionStdV1<WokaymoipInfo> actionHelper;
	
	
	public StdWokaymoipSelect(DeciTreeOption<WokaymoipInfo> option) {
		DaoStmtExec_<WokaymoipInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<WokaymoipInfo> buildStmtExec(DeciTreeOption<WokaymoipInfo> option) {
		List<DaoStmtExecOption<WokaymoipInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(WokaymoipInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<WokaymoipInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new WokaymoipSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<WokaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
