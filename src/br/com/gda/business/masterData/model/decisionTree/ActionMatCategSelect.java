package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatCategSelect;
import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatCategSelect implements DeciAction<MatCategInfo> {
	private DeciAction<MatCategInfo> actionHelper;
	
	
	public ActionMatCategSelect(DeciTreeOption<MatCategInfo> option) {
		DaoStmtExec<MatCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatCategInfo> buildStmtExec(DeciTreeOption<MatCategInfo> option) {
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
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
