package br.com.mind5.business.addressSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.dao.AddresnapInsert;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddresnapInsert implements ActionStd<AddresnapInfo> {
	private ActionStd<AddresnapInfo> actionHelper;
	
	
	public StdAddresnapInsert(DeciTreeOption<AddresnapInfo> option) {
		DaoStmtExec_<AddresnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<AddresnapInfo> buildStmtExec(DeciTreeOption<AddresnapInfo> option) {
		List<DaoStmtExecOption<AddresnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddresnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddresnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddresnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddresnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddresnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
