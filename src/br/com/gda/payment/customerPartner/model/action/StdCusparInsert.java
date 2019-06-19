package br.com.gda.payment.customerPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.payment.customerPartner.dao.CusparInsert;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCusparInsert implements ActionStd<CusparInfo> {
	private ActionStd<CusparInfo> actionHelper;
	
	
	public StdCusparInsert(DeciTreeOption<CusparInfo> option) {
		DaoStmtExec<CusparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CusparInfo> buildStmtExec(DeciTreeOption<CusparInfo> option) {
		List<DaoStmtExecOption<CusparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusparInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CusparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
