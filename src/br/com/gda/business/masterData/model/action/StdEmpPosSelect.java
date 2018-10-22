package br.com.gda.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.EmpPosSelect;
import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdEmpPosSelect implements ActionStd<EmpPosInfo> {
	private ActionStd<EmpPosInfo> actionHelper;
	
	
	public StdEmpPosSelect(DeciTreeOption<EmpPosInfo> option) {
		DaoStmtExec<EmpPosInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<EmpPosInfo> buildStmtExec(DeciTreeOption<EmpPosInfo> option) {
		List<DaoStmtExecOption<EmpPosInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EmpPosInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EmpPosInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EmpPosSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EmpPosInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EmpPosInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
