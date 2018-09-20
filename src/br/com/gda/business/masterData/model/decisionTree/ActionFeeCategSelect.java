package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.FeeCategSelect;
import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionFeeCategSelect implements DeciAction<FeeCategInfo> {
	private DeciAction<FeeCategInfo> actionHelper;
	
	
	public ActionFeeCategSelect(DeciTreeOption<FeeCategInfo> option) {
		DaoStmtExec<FeeCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FeeCategInfo> buildStmtExec(DeciTreeOption<FeeCategInfo> option) {
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
	
	
	
	@Override public void addPostAction(DeciActionHandler<FeeCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
