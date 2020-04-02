package br.com.mind5.business.materialTextDefault.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.dao.MatextaultSelect;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultSelect implements ActionStdV1<MatextaultInfo> {
	private ActionStdV1<MatextaultInfo> actionHelper;
	
	
	public StdMatextaultSelect(DeciTreeOption<MatextaultInfo> option) {
		DaoStmtExec_<MatextaultInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatextaultInfo> buildStmtExec(DeciTreeOption<MatextaultInfo> option) {
		List<DaoStmtExecOption<MatextaultInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatextaultInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatextaultInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatextaultSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatextaultInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextaultInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
