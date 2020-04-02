package br.com.mind5.business.materialSnapshot.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.dao.MatsnapSelect;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatsnapSelect implements ActionStd<MatsnapInfo> {
	private ActionStd<MatsnapInfo> actionHelper;
	
	
	public StdMatsnapSelect(DeciTreeOption<MatsnapInfo> option) {
		DaoStmtExec_<MatsnapInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatsnapInfo> buildStmtExec(DeciTreeOption<MatsnapInfo> option) {
		List<DaoStmtExecOption<MatsnapInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatsnapInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatsnapInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatsnapSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatsnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatsnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
