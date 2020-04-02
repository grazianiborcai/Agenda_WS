package br.com.mind5.business.storeSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.dao.SotarchSelect;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSotarchSelect implements ActionStdV1<SotarchInfo> {
	private ActionStdV1<SotarchInfo> actionHelper;
	
	
	public StdSotarchSelect(DeciTreeOption<SotarchInfo> option) {
		DaoStmtExec_<SotarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SotarchInfo> buildStmtExec(DeciTreeOption<SotarchInfo> option) {
		List<DaoStmtExecOption<SotarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SotarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SotarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SotarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<SotarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SotarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
