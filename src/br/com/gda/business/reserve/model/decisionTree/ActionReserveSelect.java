package br.com.gda.business.reserve.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.reserve.dao.ReserveSelect;
import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionReserveSelect implements DeciAction<ReserveInfo> {
	private DeciAction<ReserveInfo> actionHelper;
	
	
	public ActionReserveSelect(DeciTreeOption<ReserveInfo> option) {
		DaoStmtExec<ReserveInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<ReserveInfo> buildStmtExec(DeciTreeOption<ReserveInfo> option) {
		List<DaoStmtExecOption<ReserveInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(ReserveInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<ReserveInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new ReserveSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<ReserveInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ReserveInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
