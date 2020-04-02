package br.com.mind5.business.materialMovement.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.dao.MatmovInsert;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmovInsert implements ActionStdV1<MatmovInfo> {
	private ActionStdV1<MatmovInfo> actionHelper;
	
	
	public StdMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		DaoStmtExec_<MatmovInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatmovInfo> buildStmtExec(DeciTreeOption<MatmovInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatmovInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmovInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
