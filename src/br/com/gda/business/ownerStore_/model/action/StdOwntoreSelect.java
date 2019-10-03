package br.com.gda.business.ownerStore_.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerStore_.dao.OwntoreSelect;
import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOwntoreSelect implements ActionStd<OwntoreInfo> {
	private ActionStd<OwntoreInfo> actionHelper;
	
	
	public StdOwntoreSelect(DeciTreeOption<OwntoreInfo> option) {
		DaoStmtExec<OwntoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<OwntoreInfo> buildStmtExec(DeciTreeOption<OwntoreInfo> option) {
		List<DaoStmtExecOption<OwntoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(OwntoreInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<OwntoreInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new OwntoreSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwntoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwntoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
