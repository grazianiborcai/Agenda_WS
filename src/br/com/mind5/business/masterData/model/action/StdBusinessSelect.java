package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.BusinessSelect;
import br.com.mind5.business.masterData.info.BusinessInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBusinessSelect implements ActionStdV1<BusinessInfo> {
	private ActionStdV1<BusinessInfo> actionHelper;
	
	
	public StdBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		DaoStmtExec_<BusinessInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<BusinessInfo> buildStmtExec(DeciTreeOption<BusinessInfo> option) {
		List<DaoStmtExecOption<BusinessInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(BusinessInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<BusinessInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new BusinessSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<BusinessInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<BusinessInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
