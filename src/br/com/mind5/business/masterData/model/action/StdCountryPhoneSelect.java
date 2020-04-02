package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.CountryPhoneSelect;
import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountryPhoneSelect implements ActionStdV1<CountryPhoneInfo> {
	private ActionStdV1<CountryPhoneInfo> actionHelper;
	
	
	public StdCountryPhoneSelect(DeciTreeOption<CountryPhoneInfo> option) {
		DaoStmtExec_<CountryPhoneInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CountryPhoneInfo> buildStmtExec(DeciTreeOption<CountryPhoneInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<CountryPhoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CountryPhoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
