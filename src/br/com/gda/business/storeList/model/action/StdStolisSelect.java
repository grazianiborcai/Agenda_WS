package br.com.gda.business.storeList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeList.dao.StolisSelect;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdStolisSelect implements ActionStd<StolisInfo> {
	private ActionStd<StolisInfo> actionHelper;
	
	
	public StdStolisSelect(DeciTreeOption<StolisInfo> option) {
		DaoStmtExec<StolisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<StolisInfo> buildStmtExec(DeciTreeOption<StolisInfo> option) {
		List<DaoStmtExecOption<StolisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
