package br.com.gda.payService.payPartnerCountry.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerCountry.dao.PayparCountrySelect;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;

public final class StdPayparCountrySelect implements ActionStd<PayparCountryInfo> {
	private ActionStd<PayparCountryInfo> actionHelper;
	
	
	public StdPayparCountrySelect(DeciTreeOption<PayparCountryInfo> option) {
		DaoStmtExec<PayparCountryInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayparCountryInfo> buildStmtExec(DeciTreeOption<PayparCountryInfo> option) {
		List<DaoStmtExecOption<PayparCountryInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayparCountryInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayparCountryInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayparCountrySelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayparCountryInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayparCountryInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
