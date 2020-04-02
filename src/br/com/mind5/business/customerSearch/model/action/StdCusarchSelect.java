package br.com.mind5.business.customerSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSearch.dao.CusarchSelect;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusarchSelect implements ActionStdV1<CusarchInfo> {
	private ActionStdV1<CusarchInfo> actionHelper;
	
	
	public StdCusarchSelect(DeciTreeOption<CusarchInfo> option) {
		DaoStmtExec_<CusarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CusarchInfo> buildStmtExec(DeciTreeOption<CusarchInfo> option) {
		List<DaoStmtExecOption<CusarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CusarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CusarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CusarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CusarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CusarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
