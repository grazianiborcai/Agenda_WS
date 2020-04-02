package br.com.mind5.payment.customerPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.dao.CusparSelect;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class StdCusparSelect implements ActionStd<CusparInfo> {
	private ActionStd<CusparInfo> actionHelper;
	
	
	public StdCusparSelect(DeciTreeOption<CusparInfo> option) {
		DaoStmtExec_<CusparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CusparInfo> buildStmtExec(DeciTreeOption<CusparInfo> option) {
		List<DaoStmtExecOption<CusparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusparSelect(stmtExecOptions);
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
