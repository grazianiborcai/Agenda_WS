package br.com.mind5.business.store.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.dao.StoreInsert;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStoreInsert implements ActionStdV1<StoreInfo> {
	private ActionStdV1<StoreInfo> actionHelper;
	
	
	public StdStoreInsert(DeciTreeOption<StoreInfo> option) {
		DaoStmtExec_<StoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StoreInfo> buildStmtExec(DeciTreeOption<StoreInfo> option) {
		List<DaoStmtExecOption<StoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreInsert(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
