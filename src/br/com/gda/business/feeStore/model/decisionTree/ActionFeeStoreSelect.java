package br.com.gda.business.feeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.dao.FeeStoreSelect;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionFeeStoreSelect implements DeciAction<FeeStoreInfo> {
	private DeciAction<FeeStoreInfo> actionHelper;
	
	
	public ActionFeeStoreSelect(DeciTreeOption<FeeStoreInfo> option) {
		DaoStmtExec<FeeStoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FeeStoreInfo> buildStmtExec(DeciTreeOption<FeeStoreInfo> option) {
		List<DaoStmtExecOption<FeeStoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FeeStoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FeeStoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FeeStoreSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<FeeStoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeeStoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
