package br.com.gda.business.materialSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialSnapshot.dao.MatSnapInsertAttr;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdMatSnapInsertAttr implements ActionStd<MatSnapInfo> {
	private ActionStd<MatSnapInfo> actionHelper;
	
	
	public StdMatSnapInsertAttr(DeciTreeOption<MatSnapInfo> option) {
		DaoStmtExec<MatSnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<MatSnapInfo> buildStmtExec(DeciTreeOption<MatSnapInfo> option) {
		List<DaoStmtExecOption<MatSnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatSnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatSnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatSnapInsertAttr(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
