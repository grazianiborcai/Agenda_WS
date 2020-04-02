package br.com.mind5.business.materialMovementSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.dao.MatmarchSelect;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmarchSelect implements ActionStd<MatmarchInfo> {
	private ActionStd<MatmarchInfo> actionHelper;
	
	
	public StdMatmarchSelect(DeciTreeOption<MatmarchInfo> option) {
		DaoStmtExec_<MatmarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
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
	
	
	
	@Override public void addPostAction(ActionLazy<MatmarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatmarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
