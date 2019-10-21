package br.com.mind5.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.dao.CartemDelete;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemDelete implements ActionStd<CartemInfo> {
	private ActionStd<CartemInfo> actionHelper;
	
	
	public StdCartemDelete(DeciTreeOption<CartemInfo> option) {
		DaoStmtExec<CartemInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CartemInfo> buildStmtExec(DeciTreeOption<CartemInfo> option) {
		List<DaoStmtExecOption<CartemInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CartemInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CartemInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CartemDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
