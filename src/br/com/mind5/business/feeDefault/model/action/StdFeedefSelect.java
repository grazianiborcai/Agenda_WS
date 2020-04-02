package br.com.mind5.business.feeDefault.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeDefault.dao.FeedefSelect;
import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeedefSelect implements ActionStdV1<FeedefInfo> {
	private ActionStdV1<FeedefInfo> actionHelper;
	
	
	public StdFeedefSelect(DeciTreeOption<FeedefInfo> option) {
		DaoStmtExec_<FeedefInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<FeedefInfo> buildStmtExec(DeciTreeOption<FeedefInfo> option) {
		List<DaoStmtExecOption<FeedefInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FeedefInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FeedefInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FeedefSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<FeedefInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeedefInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
