package br.com.mind5.business.cart.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.dao.CartSelect;
import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartSelect implements ActionStdV1<CartInfo> {
	private ActionStdV1<CartInfo> actionHelper;
	
	
	public StdCartSelect(DeciTreeOption<CartInfo> option) {
		DaoStmtExec_<CartInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CartInfo> buildStmtExec(DeciTreeOption<CartInfo> option) {
		List<DaoStmtExecOption<CartInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CartInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CartInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CartSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CartInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
