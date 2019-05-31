package br.com.gda.business.feeDefault.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.dao.FeedefSelect;
import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFeedefSelect implements ActionStd<FeedefInfo> {
	private ActionStd<FeedefInfo> actionHelper;
	
	
	public StdFeedefSelect(DeciTreeOption<FeedefInfo> option) {
		DaoStmtExec<FeedefInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FeedefInfo> buildStmtExec(DeciTreeOption<FeedefInfo> option) {
		List<DaoStmtExecOption<FeedefInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FeedefInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FeedefInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FeedefSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FeedefInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeedefInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
