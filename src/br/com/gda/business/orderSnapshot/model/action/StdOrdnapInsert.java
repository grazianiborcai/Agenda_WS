package br.com.gda.business.orderSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderSnapshot.dao.OrdnapInsert;
import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrdnapInsert implements ActionStd<OrdnapInfo> {
	private ActionStd<OrdnapInfo> actionHelper;
	
	
	public StdOrdnapInsert(DeciTreeOption<OrdnapInfo> option) {
		DaoStmtExec<OrdnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OrdnapInfo> buildStmtExec(DeciTreeOption<OrdnapInfo> option) {
		List<DaoStmtExecOption<OrdnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrdnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrdnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrdnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
