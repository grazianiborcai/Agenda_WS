package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.MatmovTypeSelect;
import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmovTypeSelect implements ActionStdV1<MatmovTypeInfo> {
	private ActionStdV1<MatmovTypeInfo> actionHelper;
	
	
	public StdMatmovTypeSelect(DeciTreeOption<MatmovTypeInfo> option) {
		DaoStmtExec_<MatmovTypeInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatmovTypeInfo> buildStmtExec(DeciTreeOption<MatmovTypeInfo> option) {
		List<DaoStmtExecOption<MatmovTypeInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatmovTypeInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatmovTypeInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatmovTypeSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatmovTypeInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmovTypeInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
