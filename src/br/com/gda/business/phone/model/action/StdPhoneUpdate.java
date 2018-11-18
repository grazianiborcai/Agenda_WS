package br.com.gda.business.phone.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.dao.PhoneUpdate;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhoneUpdate implements ActionStd<PhoneInfo> {
	private ActionStd<PhoneInfo> actionHelper;
	
	
	public StdPhoneUpdate(DeciTreeOption<PhoneInfo> option) {
		DaoStmtExec<PhoneInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PhoneInfo> buildStmtExec(DeciTreeOption<PhoneInfo> option) {
		List<DaoStmtExecOption<PhoneInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PhoneInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PhoneInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PhoneUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
