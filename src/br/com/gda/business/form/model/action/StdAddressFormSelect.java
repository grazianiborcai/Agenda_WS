package br.com.gda.business.form.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.dao.AddressFormSelect;
import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressFormSelect implements ActionStd<AddressFormInfo> {
	private ActionStd<AddressFormInfo> actionHelper;
	
	
	public StdAddressFormSelect(DeciTreeOption<AddressFormInfo> option) {
		DaoStmtExec<AddressFormInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<AddressFormInfo> buildStmtExec(DeciTreeOption<AddressFormInfo> option) {
		List<DaoStmtExecOption<AddressFormInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddressFormInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddressFormInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddressFormSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddressFormInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressFormInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
