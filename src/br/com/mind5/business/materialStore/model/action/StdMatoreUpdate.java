package br.com.mind5.business.materialStore.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.dao.MatoreUpdate;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoreUpdate implements ActionStdV1<MatoreInfo> {
	ActionStdV1<MatoreInfo> actionHelper;
	
	
	public StdMatoreUpdate(DeciTreeOption<MatoreInfo> option) {
		DaoStmtExec_<MatoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatoreInfo> buildStmtExec(DeciTreeOption<MatoreInfo> option) {
		List<DaoStmtExecOption<MatoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatoreUpdate(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
