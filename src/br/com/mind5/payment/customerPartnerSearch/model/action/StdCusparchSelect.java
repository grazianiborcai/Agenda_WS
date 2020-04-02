package br.com.mind5.payment.customerPartnerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.dao.CusparchSelect;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class StdCusparchSelect implements ActionStd<CusparchInfo> {
	private ActionStd<CusparchInfo> actionHelper;
	
	
	public StdCusparchSelect(DeciTreeOption<CusparchInfo> option) {
		DaoStmtExec_<CusparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CusparchInfo> buildStmtExec(DeciTreeOption<CusparchInfo> option) {
		List<DaoStmtExecOption<CusparchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusparchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusparchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusparchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
