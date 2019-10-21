package br.com.mind5.business.materialMovement.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.dao.MatmovSelect;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmovSelect implements ActionStd<MatmovInfo> {
	private ActionStd<MatmovInfo> actionHelper;
	
	
	public StdMatmovSelect(DeciTreeOption<MatmovInfo> option) {
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
		
		return new MatmovSelect(stmtExecOptions);
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
