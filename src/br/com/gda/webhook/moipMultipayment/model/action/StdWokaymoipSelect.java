package br.com.gda.webhook.moipMultipayment.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.webhook.moipMultipayment.dao.WokaymoipSelect;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipSelect implements ActionStd<WokaymoipInfo> {
	private ActionStd<WokaymoipInfo> actionHelper;
	
	
	public StdWokaymoipSelect(DeciTreeOption<WokaymoipInfo> option) {
		DaoStmtExec<WokaymoipInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<WokaymoipInfo> buildStmtExec(DeciTreeOption<WokaymoipInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazy<WokaymoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<WokaymoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
