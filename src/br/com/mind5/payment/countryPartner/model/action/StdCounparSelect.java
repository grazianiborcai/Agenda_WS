package br.com.mind5.payment.countryPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.dao.CounparSelect;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class StdCounparSelect implements ActionStd<CounparInfo> {
	private ActionStd<CounparInfo> actionHelper;
	
	
	public StdCounparSelect(DeciTreeOption<CounparInfo> option) {
		DaoStmtExec<CounparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CounparInfo> buildStmtExec(DeciTreeOption<CounparInfo> option) {
		List<DaoStmtExecOption<CounparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CounparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CounparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CounparSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CounparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CounparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
