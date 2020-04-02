package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.UserCategSelect;
import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdUserCategSelect implements ActionStdV1<UserCategInfo> {
	private ActionStdV1<UserCategInfo> actionHelper;
	
	
	public StdUserCategSelect(DeciTreeOption<UserCategInfo> option) {
		DaoStmtExec_<UserCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<UserCategInfo> buildStmtExec(DeciTreeOption<UserCategInfo> option) {
		List<DaoStmtExecOption<UserCategInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(UserCategInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<UserCategInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new UserCategSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<UserCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<UserCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
