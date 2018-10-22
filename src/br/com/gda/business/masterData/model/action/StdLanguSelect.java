package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.LanguSelect;
import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdLanguSelect implements ActionStd<LanguInfo> {
	private ActionStd<LanguInfo> actionHelper;
	
	
	public StdLanguSelect(DeciTreeOption<LanguInfo> option) {
		DaoStmtExec<LanguInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<LanguInfo> buildStmtExec(DeciTreeOption<LanguInfo> option) {
		List<DaoStmtExecOption<LanguInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(LanguInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<LanguInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new LanguSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<LanguInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<LanguInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
