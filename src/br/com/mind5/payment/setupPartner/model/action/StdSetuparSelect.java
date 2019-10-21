package br.com.mind5.payment.setupPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.dao.SetuparSelect;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class StdSetuparSelect implements ActionStd<SetuparInfo> {
	private ActionStd<SetuparInfo> actionHelper;
	
	
	public StdSetuparSelect(DeciTreeOption<SetuparInfo> option) {
		DaoStmtExec<SetuparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<SetuparInfo> buildStmtExec(DeciTreeOption<SetuparInfo> option) {
		List<DaoStmtExecOption<SetuparInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(SetuparInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<SetuparInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new SetuparSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<SetuparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SetuparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
