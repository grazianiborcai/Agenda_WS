package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.CountrySelect;
import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciActionHandler;
import br.com.gda.model.decisionTree.DeciActionHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class ActionCountrySelect implements DeciAction<CountryInfo> {
	private DeciAction<CountryInfo> actionHelper;
	
	
	public ActionCountrySelect(DeciTreeOption<CountryInfo> option) {
		DaoStmtExec<CountryInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DeciActionHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CountryInfo> buildStmtExec(DeciTreeOption<CountryInfo> option) {
		List<DaoStmtExecOption<CountryInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CountryInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CountryInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CountrySelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(DeciActionHandler<CountryInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CountryInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
