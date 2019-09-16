package br.com.gda.business.companyList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.companyList.dao.ComplisSelect;
import br.com.gda.business.companyList.info.ComplisInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdComplisSelect implements ActionStd<ComplisInfo> {
	ActionStd<ComplisInfo> actionHelper;
	
	
	public StdComplisSelect(DeciTreeOption<ComplisInfo> option) {
		DaoStmtExec<ComplisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<ComplisInfo> buildStmtExec(DeciTreeOption<ComplisInfo> option) {
		List<DaoStmtExecOption<ComplisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(ComplisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<ComplisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new ComplisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ComplisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ComplisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
