package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.PositionSelect;
import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPositionSelect implements ActionStd<PositionInfo> {
	private ActionStd<PositionInfo> actionHelper;
	
	
	public StdPositionSelect(DeciTreeOption<PositionInfo> option) {
		DaoStmtExec_<PositionInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PositionInfo> buildStmtExec(DeciTreeOption<PositionInfo> option) {
		List<DaoStmtExecOption<PositionInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PositionInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PositionInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PositionSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PositionInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PositionInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
