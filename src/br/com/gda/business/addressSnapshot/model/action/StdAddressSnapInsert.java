package br.com.gda.business.addressSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.dao.AddressSnapInsert;
import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressSnapInsert implements ActionStd<AddressSnapInfo> {
	private ActionStd<AddressSnapInfo> actionHelper;
	
	
	public StdAddressSnapInsert(DeciTreeOption<AddressSnapInfo> option) {
		DaoStmtExec<AddressSnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<AddressSnapInfo> buildStmtExec(DeciTreeOption<AddressSnapInfo> option) {
		List<DaoStmtExecOption<AddressSnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddressSnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddressSnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddressSnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddressSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
