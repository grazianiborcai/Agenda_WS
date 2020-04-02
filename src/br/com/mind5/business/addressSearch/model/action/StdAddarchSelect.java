package br.com.mind5.business.addressSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.dao.AddarchSelect;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddarchSelect implements ActionStdV1<AddarchInfo> {
	private ActionStdV1<AddarchInfo> actionHelper;
	
	
	public StdAddarchSelect(DeciTreeOption<AddarchInfo> option) {
		DaoStmtExec_<AddarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<AddarchInfo> buildStmtExec(DeciTreeOption<AddarchInfo> option) {
		List<DaoStmtExecOption<AddarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(AddarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<AddarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new AddarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<AddarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
