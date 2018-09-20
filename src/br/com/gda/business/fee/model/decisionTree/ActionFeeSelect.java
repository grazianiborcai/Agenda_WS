package br.com.gda.business.fee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.fee.dao.FeeSelect;
import br.com.gda.business.fee.info.FeeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionFeeSelect implements DeciAction<FeeInfo> {
	private DeciAction<FeeInfo> actionHelper;
	
	
	public ActionFeeSelect(DeciTreeOption<FeeInfo> option) {
		DaoStmtExec<FeeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FeeInfo> buildStmtExec(DeciTreeOption<FeeInfo> option) {
		List<DaoStmtExecOption<FeeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FeeInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FeeInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FeeSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<FeeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
