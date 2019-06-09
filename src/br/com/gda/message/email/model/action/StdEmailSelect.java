package br.com.gda.message.email.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.message.email.dao.EmailSelect;
import br.com.gda.message.email.info.EmailInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmailSelect implements ActionStd<EmailInfo> {
	private ActionStd<EmailInfo> actionHelper;
	
	
	public StdEmailSelect(DeciTreeOption<EmailInfo> option) {
		DaoStmtExec<EmailInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmailInfo> buildStmtExec(DeciTreeOption<EmailInfo> option) {
		List<DaoStmtExecOption<EmailInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmailInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmailInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmailSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmailInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmailInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
