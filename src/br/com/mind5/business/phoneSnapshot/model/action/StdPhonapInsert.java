package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.dao.PhonapInsert;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonapInsert implements ActionStd<PhonapInfo> {
	private ActionStd<PhonapInfo> actionHelper;
	
	
	public StdPhonapInsert(DeciTreeOption<PhonapInfo> option) {
		DaoStmtExec<PhonapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PhonapInfo> buildStmtExec(DeciTreeOption<PhonapInfo> option) {
		List<DaoStmtExecOption<PhonapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PhonapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PhonapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PhonapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
