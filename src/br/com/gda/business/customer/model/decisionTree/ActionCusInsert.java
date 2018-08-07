package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.dao.CusInsert;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionCusInsert implements DeciAction<CusInfo> {
	DeciAction<CusInfo> actionHelper;
	
	
	public ActionCusInsert(DeciTreeOption<CusInfo> option) {
		DaoStmtExec<CusInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CusInfo> buildStmtExec(DeciTreeOption<CusInfo> option) {
		List<DaoStmtExecOption<CusInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<CusInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
