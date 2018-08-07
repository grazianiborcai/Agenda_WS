package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.dao.OwnerSelect;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionOwnerSelect implements DeciAction<OwnerInfo> {
	private DeciAction<OwnerInfo> actionHelper;
	
	
	public ActionOwnerSelect(DeciTreeOption<OwnerInfo> option) {
		DaoStmtExec<OwnerInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OwnerInfo> buildStmtExec(DeciTreeOption<OwnerInfo> option) {
		List<DaoStmtExecOption<OwnerInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnerInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnerInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnerSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
