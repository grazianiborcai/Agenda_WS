package br.com.gda.business.materialSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.dao.MatsnapInsert;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
