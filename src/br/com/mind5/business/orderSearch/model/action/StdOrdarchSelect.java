package br.com.mind5.business.orderSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSearch.dao.OrdarchSelect;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdarchSelect implements ActionStd<OrdarchInfo> {
	private ActionStd<OrdarchInfo> actionHelper;
	
	
	public StdOrdarchSelect(DeciTreeOption<OrdarchInfo> option) {
		DaoStmtExec_<OrdarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrdarchInfo> buildStmtExec(DeciTreeOption<OrdarchInfo> option) {
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
