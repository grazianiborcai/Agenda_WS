package br.com.gda.business.customerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerSearch.dao.CusarchSelect;
import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCusarchSelect implements ActionStd<CusarchInfo> {
	private ActionStd<CusarchInfo> actionHelper;
	
	
	public StdCusarchSelect(DeciTreeOption<CusarchInfo> option) {
		DaoStmtExec<CusarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CusarchInfo> buildStmtExec(DeciTreeOption<CusarchInfo> option) {
		List<DaoStmtExecOption<CusarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
