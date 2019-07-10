package br.com.gda.payment.permissionMoip.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.permissionMoip.dao.PeresmoipSelect;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;

public final class StdPeresmoipSelect implements ActionStd<PeresmoipInfo> {
	private ActionStd<PeresmoipInfo> actionHelper;
	
	
	public StdPeresmoipSelect(DeciTreeOption<PeresmoipInfo> option) {
		DaoStmtExec<PeresmoipInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<PeresmoipInfo> buildStmtExec(DeciTreeOption<PeresmoipInfo> option) {
		List<DaoStmtExecOption<PeresmoipInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PeresmoipInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PeresmoipInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PeresmoipSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PeresmoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PeresmoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
