package br.com.gda.business.feeDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeDefault.dao.FeeDefaultSelect;
import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionFeeDefaultSelect implements DeciAction<FeeDefaultInfo> {
	private DeciAction<FeeDefaultInfo> actionHelper;
	
	
	public ActionFeeDefaultSelect(DeciTreeOption<FeeDefaultInfo> option) {
		DaoStmtExec<FeeDefaultInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FeeDefaultInfo> buildStmtExec(DeciTreeOption<FeeDefaultInfo> option) {
		List<DaoStmtExecOption<FeeDefaultInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FeeDefaultInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FeeDefaultInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FeeDefaultSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<FeeDefaultInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeDefaultInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
