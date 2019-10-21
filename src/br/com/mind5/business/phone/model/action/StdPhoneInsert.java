package br.com.mind5.business.phone.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.dao.PhoneInsert;
import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhoneInsert implements ActionStd<PhoneInfo> {
	private ActionStd<PhoneInfo> actionHelper;
	
	
	public StdPhoneInsert(DeciTreeOption<PhoneInfo> option) {
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
		
		return new PhoneInsert(stmtExecOptions);
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
