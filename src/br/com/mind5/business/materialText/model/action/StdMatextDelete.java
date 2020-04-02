package br.com.mind5.business.materialText.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.dao.MatextDelete;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextDelete implements ActionStdV1<MatextInfo> {
	private ActionStdV1<MatextInfo> actionHelper;
	
	
	public StdMatextDelete(DeciTreeOption<MatextInfo> option) {
		DaoStmtExec_<MatextInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatextInfo> buildStmtExec(DeciTreeOption<MatextInfo> option) {
		List<DaoStmtExecOption<MatextInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatextInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatextInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatextDelete(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatextInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
