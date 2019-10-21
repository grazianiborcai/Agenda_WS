package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.CurrencySelect;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCurrencySelect implements ActionStd<CurrencyInfo> {
	private ActionStd<CurrencyInfo> actionHelper;
	
	
	public StdCurrencySelect(DeciTreeOption<CurrencyInfo> option) {
		DaoStmtExec<CurrencyInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CurrencyInfo> buildStmtExec(DeciTreeOption<CurrencyInfo> option) {
		List<DaoStmtExecOption<CurrencyInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CurrencyInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CurrencyInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CurrencySelect(stmtExecOptions);
	}
	
	
	@Override public void addPostAction(ActionLazy<CurrencyInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CurrencyInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
