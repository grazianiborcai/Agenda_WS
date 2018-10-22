package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.CountryPhoneSelect;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCountryPhoneSelect implements ActionStd<CountryPhoneInfo> {
	private ActionStd<CountryPhoneInfo> actionHelper;
	
	
	public StdCountryPhoneSelect(DeciTreeOption<CountryPhoneInfo> option) {
		DaoStmtExec<CountryPhoneInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CountryPhoneInfo> buildStmtExec(DeciTreeOption<CountryPhoneInfo> option) {
		List<DaoStmtExecOption<CountryPhoneInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CountryPhoneInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CountryPhoneInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CountryPhoneSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CountryPhoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CountryPhoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
