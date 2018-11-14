package br.com.gda.business.form.formAddress.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.formAddress.dao.FormAddressSelect;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFormAddressSelect implements ActionStd<FormAddressInfo> {
	private ActionStd<FormAddressInfo> actionHelper;
	
	
	public StdFormAddressSelect(DeciTreeOption<FormAddressInfo> option) {
		DaoStmtExec<FormAddressInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FormAddressInfo> buildStmtExec(DeciTreeOption<FormAddressInfo> option) {
		List<DaoStmtExecOption<FormAddressInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FormAddressInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FormAddressInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FormAddressSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FormAddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FormAddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
