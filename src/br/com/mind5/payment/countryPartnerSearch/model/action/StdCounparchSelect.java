package br.com.mind5.payment.countryPartnerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.dao.CounparchSelect;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class StdCounparchSelect implements ActionStd<CounparchInfo> {
	private ActionStd<CounparchInfo> actionHelper;
	
	
	public StdCounparchSelect(DeciTreeOption<CounparchInfo> option) {
		DaoStmtExec<CounparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CounparchInfo> buildStmtExec(DeciTreeOption<CounparchInfo> option) {
		List<DaoStmtExecOption<CounparchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CounparchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CounparchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CounparchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CounparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CounparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
