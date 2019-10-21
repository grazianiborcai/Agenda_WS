package br.com.mind5.business.address.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.dao.AddressSelect;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressSelect implements ActionStd<AddressInfo> {
	private ActionStd<AddressInfo> actionHelper;
	
	
	public StdAddressSelect(DeciTreeOption<AddressInfo> option) {
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
		
		return new AddressSelect(stmtExecOptions);
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
