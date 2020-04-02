package br.com.mind5.business.orderItemSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSearch.dao.OrdemarchSelect;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemarchSelect implements ActionStd<OrdemarchInfo> {
	private ActionStd<OrdemarchInfo> actionHelper;
	
	
	public StdOrdemarchSelect(DeciTreeOption<OrdemarchInfo> option) {
		DaoStmtExec_<OrdemarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OrdemarchInfo> buildStmtExec(DeciTreeOption<OrdemarchInfo> option) {
		List<DaoStmtExecOption<OrdemarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OrdemarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OrdemarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OrdemarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdemarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdemarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
