package br.com.gda.business.storeSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeSearch.dao.SotarchSelect;
import br.com.gda.business.storeSearch.info.SotarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdSotarchSelect implements ActionStd<SotarchInfo> {
	private ActionStd<SotarchInfo> actionHelper;
	
	
	public StdSotarchSelect(DeciTreeOption<SotarchInfo> option) {
		DaoStmtExec<SotarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SotarchInfo> buildStmtExec(DeciTreeOption<SotarchInfo> option) {
		List<DaoStmtExecOption<SotarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SotarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SotarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SotarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
