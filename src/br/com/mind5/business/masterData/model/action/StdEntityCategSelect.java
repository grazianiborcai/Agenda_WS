package br.com.mind5.business.masterData.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.dao.EntityCategSelect;
import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEntityCategSelect implements ActionStd<EntityCategInfo> {
	private ActionStd<EntityCategInfo> actionHelper;
	
	
	public StdEntityCategSelect(DeciTreeOption<EntityCategInfo> option) {
		DaoStmtExec_<EntityCategInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<EntityCategInfo> buildStmtExec(DeciTreeOption<EntityCategInfo> option) {
		List<DaoStmtExecOption<EntityCategInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(EntityCategInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<EntityCategInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new EntityCategSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<EntityCategInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<EntityCategInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
