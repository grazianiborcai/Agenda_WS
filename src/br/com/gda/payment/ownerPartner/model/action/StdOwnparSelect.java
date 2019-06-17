package br.com.gda.payment.ownerPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.ownerPartner.dao.OwnparSelect;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

public final class StdOwnparSelect implements ActionStd<OwnparInfo> {
	private ActionStd<OwnparInfo> actionHelper;
	
	
	public StdOwnparSelect(DeciTreeOption<OwnparInfo> option) {
		DaoStmtExec<OwnparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OwnparInfo> buildStmtExec(DeciTreeOption<OwnparInfo> option) {
		List<DaoStmtExecOption<OwnparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnparSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
