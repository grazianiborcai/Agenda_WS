package br.com.mind5.business.phoneSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.dao.PhonarchSelect;
import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonarchSelect implements ActionStdV1<PhonarchInfo> {
	private ActionStdV1<PhonarchInfo> actionHelper;
	
	
	public StdPhonarchSelect(DeciTreeOption<PhonarchInfo> option) {
		DaoStmtExec_<PhonarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PhonarchInfo> buildStmtExec(DeciTreeOption<PhonarchInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<PhonarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhonarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
