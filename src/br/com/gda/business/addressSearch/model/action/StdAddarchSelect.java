package br.com.gda.business.addressSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSearch.dao.AddarchSelect;
import br.com.gda.business.addressSearch.info.AddarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddarchSelect implements ActionStd<AddarchInfo> {
	private ActionStd<AddarchInfo> actionHelper;
	
	
	public StdAddarchSelect(DeciTreeOption<AddarchInfo> option) {
		DaoStmtExec<AddarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<AddarchInfo> buildStmtExec(DeciTreeOption<AddarchInfo> option) {
		List<DaoStmtExecOption<AddarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
