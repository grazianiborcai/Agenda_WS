package br.com.gda.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartItem.dao.CartemUpdate;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartemUpdateItm implements ActionStd<CartemInfo> {
	private ActionStd<CartemInfo> actionHelper;
	
	
	public StdCartemUpdateItm(DeciTreeOption<CartemInfo> option) {
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
		
		return new CartemUpdate(stmtExecOptions);
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
