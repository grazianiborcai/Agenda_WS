package br.com.mind5.business.materialTextSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.dao.MatextsnapSelect;
import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextsnapSelect implements ActionStdV1<MatextsnapInfo> {
	private ActionStdV1<MatextsnapInfo> actionHelper;
	
	
	public StdMatextsnapSelect(DeciTreeOption<MatextsnapInfo> option) {
		DaoStmtExec_<MatextsnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatextsnapInfo> buildStmtExec(DeciTreeOption<MatextsnapInfo> option) {
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
	
	
	
	@Override public void addPostAction(ActionLazyV1<MatextsnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatextsnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
