package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.LanguSelect;
import br.com.mind5.business.masterData.info.LanguInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdLanguSelect implements ActionStdV1<LanguInfo> {
	private ActionStdV1<LanguInfo> actionHelper;
	
	
	public StdLanguSelect(DeciTreeOption<LanguInfo> option) {
		DaoStmtExec_<LanguInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<LanguInfo> buildStmtExec(DeciTreeOption<LanguInfo> option) {
		List<DaoStmtExecOption<LanguInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(LanguInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<LanguInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new LanguSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<LanguInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<LanguInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
