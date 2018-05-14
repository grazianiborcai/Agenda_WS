package br.com.gda.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreStmtExecSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreActionSelect implements DecisionAction<StoreInfo> {
	DecisionAction<StoreInfo> actionHelper;
	
	
	public StoreActionSelect(DecisionTreeOption<StoreInfo> option) {
		SqlStmtExec<StoreInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<StoreInfo> buildStmtExec(DecisionTreeOption<StoreInfo> option) {
		List<SqlStmtExecOption<StoreInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(StoreInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<StoreInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new StoreStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DecisionResult<StoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
