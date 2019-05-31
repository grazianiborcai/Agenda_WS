package br.com.gda.business.feeOwner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeOwner.dao.FeewnerSelect;
import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFeewnerSelect implements ActionStd<FeewnerInfo> {
	private ActionStd<FeewnerInfo> actionHelper;
	
	
	public StdFeewnerSelect(DeciTreeOption<FeewnerInfo> option) {
		DaoStmtExec<FeewnerInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<FeewnerInfo> buildStmtExec(DeciTreeOption<FeewnerInfo> option) {
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
