package br.com.gda.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.dao.MatUpdateAttr;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionMatUpdateAttr implements DeciAction<MatInfo> {
	private DeciAction<MatInfo> actionHelper;
	
	
	public ActionMatUpdateAttr(DeciTreeOption<MatInfo> option) {
		DaoStmtExec<MatInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatInfo> buildStmtExec(DeciTreeOption<MatInfo> option) {
		List<DaoStmtExecOption<MatInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatUpdateAttr(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
