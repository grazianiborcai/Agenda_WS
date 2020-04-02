package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.FeeCategSelect;
import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeeCategSelect implements ActionStdV1<FeeCategInfo> {
	private ActionStdV1<FeeCategInfo> actionHelper;
	
	
	public StdFeeCategSelect(DeciTreeOption<FeeCategInfo> option) {
		DaoStmtExec_<FeeCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<FeeCategInfo> buildStmtExec(DeciTreeOption<FeeCategInfo> option) {
		List<DaoStmtExecOption<FeeCategInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FeeCategInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FeeCategInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FeeCategSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<FeeCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
