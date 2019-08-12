package br.com.gda.business.schedule.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.schedule.dao.ScheduSelect;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdScheduSelect implements ActionStd<ScheduInfo> {
	private ActionStd<ScheduInfo> actionHelper;
	
	
	public StdScheduSelect(DeciTreeOption<ScheduInfo> option) {
		DaoStmtExec<ScheduInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<ScheduInfo> buildStmtExec(DeciTreeOption<ScheduInfo> option) {
		List<DaoStmtExecOption<ScheduInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(ScheduInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<ScheduInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new ScheduSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<ScheduInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<ScheduInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
