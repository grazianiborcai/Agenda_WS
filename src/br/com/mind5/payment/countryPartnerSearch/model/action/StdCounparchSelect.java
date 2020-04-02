package br.com.mind5.payment.countryPartnerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartnerSearch.dao.CounparchSelect;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class StdCounparchSelect implements ActionStdV1<CounparchInfo> {
	private ActionStdV1<CounparchInfo> actionHelper;
	
	
	public StdCounparchSelect(DeciTreeOption<CounparchInfo> option) {
		DaoStmtExec_<CounparchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CounparchInfo> buildStmtExec(DeciTreeOption<CounparchInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<CounparchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CounparchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
