package br.com.gda.business.cartSnapshot_.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartSnapshot_.dao.CartSnapInsertItm;
import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class StdCartSnapInsertItm implements ActionStd<CartSnapInfo> {
	private ActionStd<CartSnapInfo> actionHelper;
	
	
	public StdCartSnapInsertItm(DeciTreeOption<CartSnapInfo> option) {
		DaoStmtExec<CartSnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CartSnapInfo> buildStmtExec(DeciTreeOption<CartSnapInfo> option) {
		List<DaoStmtExecOption<CartSnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CartSnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CartSnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CartSnapInsertItm(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
