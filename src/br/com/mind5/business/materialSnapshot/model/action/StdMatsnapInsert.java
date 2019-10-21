package br.com.mind5.business.materialSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.dao.MatsnapInsert;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatsnapInsert implements ActionStd<MatsnapInfo> {
	private ActionStd<MatsnapInfo> actionHelper;
	
	
	public StdMatsnapInsert(DeciTreeOption<MatsnapInfo> option) {
		DaoStmtExec<MatsnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatsnapInfo> buildStmtExec(DeciTreeOption<MatsnapInfo> option) {
		List<DaoStmtExecOption<MatsnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatsnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatsnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatsnapInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatsnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatsnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
