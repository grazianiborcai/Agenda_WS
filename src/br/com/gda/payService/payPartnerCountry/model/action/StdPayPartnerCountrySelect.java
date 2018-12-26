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
import br.com.gda.payService.payPartnerCountry.dao.PayPartnerCountrySelect;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;

public final class StdPayPartnerCountrySelect implements ActionStd<PayPartnerCountryInfo> {
	private ActionStd<PayPartnerCountryInfo> actionHelper;
	
	
	public StdPayPartnerCountrySelect(DeciTreeOption<PayPartnerCountryInfo> option) {
		DaoStmtExec<PayPartnerCountryInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PayPartnerCountryInfo> buildStmtExec(DeciTreeOption<PayPartnerCountryInfo> option) {
		List<DaoStmtExecOption<PayPartnerCountryInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PayPartnerCountryInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PayPartnerCountryInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PayPartnerCountrySelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayPartnerCountryInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayPartnerCountryInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
