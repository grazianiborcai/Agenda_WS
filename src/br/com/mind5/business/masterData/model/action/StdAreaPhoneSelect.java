package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.AreaPhoneSelect;
import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAreaPhoneSelect implements ActionStd<AreaPhoneInfo> {
	private ActionStd<AreaPhoneInfo> actionHelper;
	
	
	public StdAreaPhoneSelect(DeciTreeOption<AreaPhoneInfo> option) {
		DaoStmtExec_<AreaPhoneInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<AreaPhoneInfo> buildStmtExec(DeciTreeOption<AreaPhoneInfo> option) {
		List<DaoStmtExecOption<AreaPhoneInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AreaPhoneInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AreaPhoneInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AreaPhoneSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AreaPhoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AreaPhoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
