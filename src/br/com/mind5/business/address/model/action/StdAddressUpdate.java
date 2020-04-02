package br.com.mind5.business.address.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.dao.AddressUpdate;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressUpdate implements ActionStdV1<AddressInfo> {
	private ActionStdV1<AddressInfo> actionHelper;
	
	
	public StdAddressUpdate(DeciTreeOption<AddressInfo> option) {
		DaoStmtExec_<AddressInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<AddressInfo> buildStmtExec(DeciTreeOption<AddressInfo> option) {
		List<DaoStmtExecOption<AddressInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddressInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddressInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddressUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<AddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
