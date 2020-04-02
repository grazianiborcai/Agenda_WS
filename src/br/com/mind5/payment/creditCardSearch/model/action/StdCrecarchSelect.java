package br.com.mind5.payment.creditCardSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCardSearch.dao.CrecarchSelect;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class StdCrecarchSelect implements ActionStd<CrecarchInfo> {
	private ActionStd<CrecarchInfo> actionHelper;
	
	
	public StdCrecarchSelect(DeciTreeOption<CrecarchInfo> option) {
		DaoStmtExec_<CrecarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CrecarchInfo> buildStmtExec(DeciTreeOption<CrecarchInfo> option) {
		List<DaoStmtExecOption<CrecarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CrecarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CrecarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CrecarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CrecarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CrecarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
