package br.com.gda.business.phoneSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.dao.PhoneSnapInsert;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhoneSnapInsert implements ActionStd<PhoneSnapInfo> {
	private ActionStd<PhoneSnapInfo> actionHelper;
	
	
	public StdPhoneSnapInsert(DeciTreeOption<PhoneSnapInfo> option) {
		DaoStmtExec<PhoneSnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PhoneSnapInfo> buildStmtExec(DeciTreeOption<PhoneSnapInfo> option) {
		List<DaoStmtExecOption<PhoneSnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PhoneSnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PhoneSnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PhoneSnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhoneSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhoneSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
