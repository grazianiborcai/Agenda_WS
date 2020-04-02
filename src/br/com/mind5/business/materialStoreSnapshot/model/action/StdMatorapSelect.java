package br.com.mind5.business.materialStoreSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSnapshot.dao.MatorapSelect;
import br.com.mind5.business.materialStoreSnapshot.info.MatorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorapSelect implements ActionStdV1<MatorapInfo> {
	private ActionStdV1<MatorapInfo> actionHelper;
	
	
	public StdMatorapSelect(DeciTreeOption<MatorapInfo> option) {
		DaoStmtExec_<MatorapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatorapInfo> buildStmtExec(DeciTreeOption<MatorapInfo> option) {
		List<DaoStmtExecOption<MatorapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatorapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatorapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatorapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatorapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatorapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
