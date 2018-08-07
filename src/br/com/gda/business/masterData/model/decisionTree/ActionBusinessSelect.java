package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.BusinessSelect;
import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionBusinessSelect implements DeciAction<BusinessInfo> {
	private DeciAction<BusinessInfo> actionHelper;
	
	
	public ActionBusinessSelect(DeciTreeOption<BusinessInfo> option) {
		DaoStmtExec<BusinessInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
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
