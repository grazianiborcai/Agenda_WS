package br.com.gda.business.address.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.dao.AddressInsert;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressInsert implements ActionStd<AddressInfo> {
	private ActionStd<AddressInfo> actionHelper;
	
	
	public StdAddressInsert(DeciTreeOption<AddressInfo> option) {
		DaoStmtExec<AddressInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<AddressInfo> buildStmtExec(DeciTreeOption<AddressInfo> option) {
		List<DaoStmtExecOption<AddressInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddressInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddressInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddressInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
