package br.com.mind5.business.feeOwner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.dao.FeewnerSelect;
import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeewnerSelect implements ActionStd<FeewnerInfo> {
	private ActionStd<FeewnerInfo> actionHelper;
	
	
	public StdFeewnerSelect(DeciTreeOption<FeewnerInfo> option) {
		DaoStmtExec_<FeewnerInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<FeewnerInfo> buildStmtExec(DeciTreeOption<FeewnerInfo> option) {
		List<DaoStmtExecOption<FeewnerInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(FeewnerInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<FeewnerInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new FeewnerSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FeewnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeewnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
