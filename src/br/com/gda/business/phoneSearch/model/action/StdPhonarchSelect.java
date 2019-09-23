package br.com.gda.business.phoneSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSearch.dao.PhonarchSelect;
import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhonarchSelect implements ActionStd<PhonarchInfo> {
	private ActionStd<PhonarchInfo> actionHelper;
	
	
	public StdPhonarchSelect(DeciTreeOption<PhonarchInfo> option) {
		DaoStmtExec<PhonarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PhonarchInfo> buildStmtExec(DeciTreeOption<PhonarchInfo> option) {
		List<DaoStmtExecOption<PhonarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PhonarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PhonarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PhonarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhonarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhonarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
