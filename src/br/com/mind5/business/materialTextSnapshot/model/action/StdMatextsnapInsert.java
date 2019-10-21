package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.dao.MatextsnapInsert;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextsnapInsert implements ActionStd<MatextsnapInfo> {
	private ActionStd<MatextsnapInfo> actionHelper;
	
	
	public StdMatextsnapInsert(DeciTreeOption<MatextsnapInfo> option) {
		DaoStmtExec<MatextsnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatextsnapInfo> buildStmtExec(DeciTreeOption<MatextsnapInfo> option) {
		List<DaoStmtExecOption<MatextsnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatextsnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatextsnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatextsnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextsnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextsnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
