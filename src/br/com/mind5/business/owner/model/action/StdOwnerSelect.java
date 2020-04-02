package br.com.mind5.business.owner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.dao.OwnerSelect;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerSelect implements ActionStdV1<OwnerInfo> {
	private ActionStdV1<OwnerInfo> actionHelper;
	
	
	public StdOwnerSelect(DeciTreeOption<OwnerInfo> option) {
		DaoStmtExec_<OwnerInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<OwnerInfo> buildStmtExec(DeciTreeOption<OwnerInfo> option) {
		List<DaoStmtExecOption<OwnerInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwnerInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwnerInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwnerSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<OwnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
