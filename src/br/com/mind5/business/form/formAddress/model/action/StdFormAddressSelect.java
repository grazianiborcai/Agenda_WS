package br.com.mind5.business.form.formAddress.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddress.dao.FormAddressSelect;
import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFormAddressSelect implements ActionStdV1<FormAddressInfo> {
	private ActionStdV1<FormAddressInfo> actionHelper;
	
	
	public StdFormAddressSelect(DeciTreeOption<FormAddressInfo> option) {
		DaoStmtExec_<FormAddressInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<FormAddressInfo> buildStmtExec(DeciTreeOption<FormAddressInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<FormAddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FormAddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
