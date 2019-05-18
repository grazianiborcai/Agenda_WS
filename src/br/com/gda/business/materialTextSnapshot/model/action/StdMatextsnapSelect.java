package br.com.gda.business.materialTextSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialTextSnapshot.dao.MatextsnapSelect;
import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatextsnapSelect implements ActionStd<MatextsnapInfo> {
	private ActionStd<MatextsnapInfo> actionHelper;
	
	
	public StdMatextsnapSelect(DeciTreeOption<MatextsnapInfo> option) {
		DaoStmtExec<MatextsnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatextsnapInfo> buildStmtExec(DeciTreeOption<MatextsnapInfo> option) {
		List<DaoStmtExecOption<MatextsnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatextsnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatextsnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatextsnapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatextsnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextsnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
