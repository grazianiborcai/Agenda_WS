package br.com.gda.business.phoneSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.dao.PhonapInsert;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
