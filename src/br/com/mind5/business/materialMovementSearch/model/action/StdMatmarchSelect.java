package br.com.mind5.business.materialMovementSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.dao.MatmarchSelect;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmarchSelect implements ActionStdV1<MatmarchInfo> {
	private ActionStdV1<MatmarchInfo> actionHelper;
	
	
	public StdMatmarchSelect(DeciTreeOption<MatmarchInfo> option) {
		DaoStmtExec_<MatmarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatmarchInfo> buildStmtExec(DeciTreeOption<MatmarchInfo> option) {
		List<DaoStmtExecOption<MatmarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatmarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatmarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatmarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatmarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
