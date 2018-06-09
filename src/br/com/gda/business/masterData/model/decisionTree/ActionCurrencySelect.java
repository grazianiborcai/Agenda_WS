package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.CurrencySelectExec;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelper;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class ActionCurrencySelect implements DeciAction<CurrencyInfo> {
	private DeciAction<CurrencyInfo> actionHelper;
	
	
	public ActionCurrencySelect(DeciTreeOption<CurrencyInfo> option) {
		SqlStmtExec<CurrencyInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<CurrencyInfo> buildStmtExec(DeciTreeOption<CurrencyInfo> option) {
		List<SqlStmtExecOption<CurrencyInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CurrencyInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<CurrencyInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CurrencySelectExec(stmtExecOptions);
	}
	
	
	@Override public void addPostAction(DeciActionHandler<CurrencyInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CurrencyInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
