package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.BusinessSelectExec;
import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionBusinessSelect implements DeciAction<BusinessInfo> {
	private DeciAction<BusinessInfo> actionHelper;
	
	
	public ActionBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		SqlStmtExec<BusinessInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<BusinessInfo> buildStmtExec(DeciTreeOption<BusinessInfo> option) {
		List<SqlStmtExecOption<BusinessInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(BusinessInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<BusinessInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new BusinessSelectExec(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<BusinessInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<BusinessInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
