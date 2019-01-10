package br.com.gda.business.owner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.dao.OwnerDelete;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOwnerDelete implements ActionStd<OwnerInfo> {
	private ActionStd<OwnerInfo> actionHelper;
	
	
	public StdOwnerDelete(DeciTreeOption<OwnerInfo> option) {
		DaoStmtExec<OwnerInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OwnerInfo> buildStmtExec(DeciTreeOption<OwnerInfo> option) {
		List<DaoStmtExecOption<OwnerInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnerInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnerInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnerDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
