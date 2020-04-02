package br.com.mind5.payment.setupPartner.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.dao.SetuparSelect;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class StdSetuparSelect implements ActionStdV1<SetuparInfo> {
	private ActionStdV1<SetuparInfo> actionHelper;
	
	
	public StdSetuparSelect(DeciTreeOption<SetuparInfo> option) {
		DaoStmtExec_<SetuparInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<SetuparInfo> buildStmtExec(DeciTreeOption<SetuparInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<SetuparInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<SetuparInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
