package br.com.mind5.business.materialStoreSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.dao.MatorarchSelect;
import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorarchSelect implements ActionStdV1<MatorarchInfo> {
	private ActionStdV1<MatorarchInfo> actionHelper;
	
	
	public StdMatorarchSelect(DeciTreeOption<MatorarchInfo> option) {
		DaoStmtExec_<MatorarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatorarchInfo> buildStmtExec(DeciTreeOption<MatorarchInfo> option) {
		List<DaoStmtExecOption<MatorarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatorarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatorarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatorarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatorarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatorarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
