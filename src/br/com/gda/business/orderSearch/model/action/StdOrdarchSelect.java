package br.com.gda.business.orderSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderSearch.dao.OrdarchSelect;
import br.com.gda.business.orderSearch.info.OrdarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrdarchSelect implements ActionStd<OrdarchInfo> {
	private ActionStd<OrdarchInfo> actionHelper;
	
	
	public StdOrdarchSelect(DeciTreeOption<OrdarchInfo> option) {
		DaoStmtExec<OrdarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OrdarchInfo> buildStmtExec(DeciTreeOption<OrdarchInfo> option) {
		List<DaoStmtExecOption<OrdarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrdarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrdarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrdarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
