package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.GenderSelect;
import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGenderSelect implements ActionStd<GenderInfo> {
	private ActionStd<GenderInfo> actionHelper;
	
	
	public StdGenderSelect(DeciTreeOption<GenderInfo> option) {
		DaoStmtExec<GenderInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<GenderInfo> buildStmtExec(DeciTreeOption<GenderInfo> option) {
		List<DaoStmtExecOption<GenderInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(GenderInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<GenderInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new GenderSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<GenderInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<GenderInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
