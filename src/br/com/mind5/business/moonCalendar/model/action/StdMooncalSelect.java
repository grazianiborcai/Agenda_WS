package br.com.mind5.business.moonCalendar.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.dao.MooncalSelect;
import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMooncalSelect implements ActionStdV1<MooncalInfo> {
	private ActionStdV1<MooncalInfo> actionHelper;
	
	
	public StdMooncalSelect(DeciTreeOption<MooncalInfo> option) {
		DaoStmtExec_<MooncalInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MooncalInfo> buildStmtExec(DeciTreeOption<MooncalInfo> option) {
		List<DaoStmtExecOption<MooncalInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MooncalInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MooncalInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MooncalSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<MooncalInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MooncalInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
