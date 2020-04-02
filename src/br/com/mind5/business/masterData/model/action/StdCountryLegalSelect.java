package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.CountryLegalSelect;
import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCountryLegalSelect implements ActionStdV1<CountryLegalInfo> {
	private ActionStdV1<CountryLegalInfo> actionHelper;
	
	
	public StdCountryLegalSelect(DeciTreeOption<CountryLegalInfo> option) {
		DaoStmtExec_<CountryLegalInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CountryLegalInfo> buildStmtExec(DeciTreeOption<CountryLegalInfo> option) {
		List<DaoStmtExecOption<CountryLegalInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CountryLegalInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CountryLegalInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CountryLegalSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CountryLegalInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CountryLegalInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
