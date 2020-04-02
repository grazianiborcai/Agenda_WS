package br.com.mind5.payment.countryPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.countryPartner.dao.CounparSelect;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class StdCounparSelect implements ActionStdV1<CounparInfo> {
	private ActionStdV1<CounparInfo> actionHelper;
	
	
	public StdCounparSelect(DeciTreeOption<CounparInfo> option) {
		DaoStmtExec_<CounparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CounparInfo> buildStmtExec(DeciTreeOption<CounparInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<CounparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CounparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
