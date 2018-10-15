package br.com.gda.business.cart.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.dao.CartDeleteHdr;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartDeleteHdr implements ActionStd<CartInfo> {
	private ActionStd<CartInfo> actionHelper;
	
	
	public StdCartDeleteHdr(DeciTreeOption<CartInfo> option) {
		DaoStmtExec<CartInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CartInfo> buildStmtExec(DeciTreeOption<CartInfo> option) {
		List<DaoStmtExecOption<CartInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CartInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CartInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CartDeleteHdr(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
