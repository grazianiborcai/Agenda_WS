package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatUnitSelect;
import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionMatUnitSelect implements DeciAction<MatUnitInfo> {
	private DeciAction<MatUnitInfo> actionHelper;
	
	
	public ActionMatUnitSelect(DeciTreeOption<MatUnitInfo> option) {
		DaoStmtExec<MatUnitInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatUnitInfo> buildStmtExec(DeciTreeOption<MatUnitInfo> option) {
		List<DaoStmtExecOption<MatUnitInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatUnitInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatUnitInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatUnitSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<MatUnitInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatUnitInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
