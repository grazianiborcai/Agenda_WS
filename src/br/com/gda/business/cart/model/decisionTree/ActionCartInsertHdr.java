package br.com.gda.business.cart.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cart.dao.CartInsertHdr;
import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class ActionCartInsertHdr implements DeciAction<CartInfo> {
	private DeciAction<CartInfo> actionHelper;
	
	
	public ActionCartInsertHdr(DeciTreeOption<CartInfo> option) {
		DaoStmtExec<CartInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
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
		
		return new CartInsertHdr(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<CartInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
