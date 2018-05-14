package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreEmpStmtExecUpdate;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreEmpActionUpdate implements DecisionAction<StoreEmpInfo> {
	DecisionAction<StoreEmpInfo> actionHelper;
	
	
	public StoreEmpActionUpdate(DecisionTreeOption<StoreEmpInfo> option) {
		SqlStmtExec<StoreEmpInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<StoreEmpInfo> buildStmtExec(DecisionTreeOption<StoreEmpInfo> option) {
		List<SqlStmtExecOption<StoreEmpInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreEmpInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<StoreEmpInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreEmpStmtExecUpdate(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DecisionResult<StoreEmpInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
