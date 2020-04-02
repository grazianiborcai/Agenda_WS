package br.com.mind5.payment.systemPartnerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.systemPartnerSearch.dao.SysparchSelect;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class StdSysparchSelect implements ActionStd<SysparchInfo> {
	private ActionStd<SysparchInfo> actionHelper;
	
	
	public StdSysparchSelect(DeciTreeOption<SysparchInfo> option) {
		DaoStmtExec_<SysparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SysparchInfo> buildStmtExec(DeciTreeOption<SysparchInfo> option) {
		List<DaoStmtExecOption<SysparchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SysparchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SysparchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SysparchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SysparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SysparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
