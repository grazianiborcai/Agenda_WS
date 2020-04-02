package br.com.mind5.business.storeList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.dao.StolisSelect;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolisSelect implements ActionStdV1<StolisInfo> {
	private ActionStdV1<StolisInfo> actionHelper;
	
	
	public StdStolisSelect(DeciTreeOption<StolisInfo> option) {
		DaoStmtExec_<StolisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<StolisInfo> buildStmtExec(DeciTreeOption<StolisInfo> option) {
		List<DaoStmtExecOption<StolisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StolisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<StolisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StolisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StolisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
