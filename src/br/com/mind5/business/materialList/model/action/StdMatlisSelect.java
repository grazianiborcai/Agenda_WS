package br.com.mind5.business.materialList.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.dao.MatlisSelect;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatlisSelect implements ActionStd<MatlisInfo> {
	private ActionStd<MatlisInfo> actionHelper;
	
	
	public StdMatlisSelect(DeciTreeOption<MatlisInfo> option) {
		DaoStmtExec_<MatlisInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<MatlisInfo> buildStmtExec(DeciTreeOption<MatlisInfo> option) {
		List<DaoStmtExecOption<MatlisInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(MatlisInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<MatlisInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new MatlisSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<MatlisInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<MatlisInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
