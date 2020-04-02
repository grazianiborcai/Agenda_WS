package br.com.mind5.business.orderSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSnapshot.dao.OrdnapInsert;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdnapInsert implements ActionStd<OrdnapInfo> {
	private ActionStd<OrdnapInfo> actionHelper;
	
	
	public StdOrdnapInsert(DeciTreeOption<OrdnapInfo> option) {
		DaoStmtExec_<OrdnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrdnapInfo> buildStmtExec(DeciTreeOption<OrdnapInfo> option) {
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
