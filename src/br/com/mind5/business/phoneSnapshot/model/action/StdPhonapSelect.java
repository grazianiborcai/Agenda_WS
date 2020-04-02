package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.dao.PhonapSelect;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonapSelect implements ActionStdV1<PhonapInfo> {
	private ActionStdV1<PhonapInfo> actionHelper;
	
	
	public StdPhonapSelect(DeciTreeOption<PhonapInfo> option) {
		DaoStmtExec_<PhonapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<PhonapInfo> buildStmtExec(DeciTreeOption<PhonapInfo> option) {
		List<DaoStmtExecOption<PhonapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PhonapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<PhonapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PhonapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<PhonapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhonapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
