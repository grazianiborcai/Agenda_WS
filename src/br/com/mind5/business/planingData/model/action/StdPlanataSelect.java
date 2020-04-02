package br.com.mind5.business.planingData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.dao.PlanataSelect;
import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPlanataSelect implements ActionStd<PlanataInfo> {
	ActionStd<PlanataInfo> actionHelper;
	
	
	public StdPlanataSelect(DeciTreeOption<PlanataInfo> option) {
		DaoStmtExec_<PlanataInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PlanataInfo> buildStmtExec(DeciTreeOption<PlanataInfo> option) {
		List<DaoStmtExecOption<PlanataInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PlanataInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PlanataInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PlanataSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PlanataInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PlanataInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
