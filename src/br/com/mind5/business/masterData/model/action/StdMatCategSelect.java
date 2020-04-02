package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.MatCategSelect;
import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatCategSelect implements ActionStd<MatCategInfo> {
	private ActionStd<MatCategInfo> actionHelper;
	
	
	public StdMatCategSelect(DeciTreeOption<MatCategInfo> option) {
		DaoStmtExec_<MatCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatCategInfo> buildStmtExec(DeciTreeOption<MatCategInfo> option) {
		List<DaoStmtExecOption<MatCategInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatCategInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatCategInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatCategSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
