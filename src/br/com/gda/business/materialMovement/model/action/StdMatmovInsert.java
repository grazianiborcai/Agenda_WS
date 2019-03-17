package br.com.gda.business.materialMovement.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialMovement.dao.MatmovInsert;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatmovInsert implements ActionStd<MatmovInfo> {
	private ActionStd<MatmovInfo> actionHelper;
	
	
	public StdMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		DaoStmtExec<MatmovInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatmovInfo> buildStmtExec(DeciTreeOption<MatmovInfo> option) {
		List<DaoStmtExecOption<MatmovInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatmovInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatmovInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatmovInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatmovInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmovInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
