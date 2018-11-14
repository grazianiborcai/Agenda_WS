package br.com.gda.business.form.formPhone.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.formPhone.dao.FormPhoneSelect;
import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFormPhoneSelect implements ActionStd<FormPhoneInfo> {
	private ActionStd<FormPhoneInfo> actionHelper;
	
	
	public StdFormPhoneSelect(DeciTreeOption<FormPhoneInfo> option) {
		DaoStmtExec<FormPhoneInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FormPhoneInfo> buildStmtExec(DeciTreeOption<FormPhoneInfo> option) {
		List<DaoStmtExecOption<FormPhoneInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FormPhoneInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FormPhoneInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FormPhoneSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FormPhoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FormPhoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
