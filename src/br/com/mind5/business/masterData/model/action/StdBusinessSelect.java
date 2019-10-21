package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.BusinessSelect;
import br.com.mind5.business.masterData.info.BusinessInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBusinessSelect implements ActionStd<BusinessInfo> {
	private ActionStd<BusinessInfo> actionHelper;
	
	
	public StdBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		DaoStmtExec<BusinessInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<BusinessInfo> buildStmtExec(DeciTreeOption<BusinessInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazy<BusinessInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<BusinessInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
