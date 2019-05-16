package br.com.gda.business.addressSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.dao.AddresnapSelect;
import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddresnapSelect implements ActionStd<AddresnapInfo> {
	private ActionStd<AddresnapInfo> actionHelper;
	
	
	public StdAddresnapSelect(DeciTreeOption<AddresnapInfo> option) {
		DaoStmtExec<AddresnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<AddresnapInfo> buildStmtExec(DeciTreeOption<AddresnapInfo> option) {
		List<DaoStmtExecOption<AddresnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddresnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddresnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddresnapSelect(stmtExecOptions);
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
