package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.PositionStmtExecSelect;
import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.model.decisionTree.DecisionAction;
import br.com.gda.model.decisionTree.DecisionActionStmtHelper;
import br.com.gda.model.decisionTree.DecisionResult;
import br.com.gda.model.decisionTree.DecisionTreeOption;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class PositionActionSelect implements DecisionAction<PositionInfo> {
	DecisionAction<PositionInfo> actionHelper;
	
	
	public PositionActionSelect(DecisionTreeOption<PositionInfo> option) {
		SqlStmtExec<PositionInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new DecisionActionStmtHelper<>(sqlStmtExecutor);
	}
	
	
	
	private SqlStmtExec<PositionInfo> buildStmtExec(DecisionTreeOption<PositionInfo> option) {
		List<SqlStmtExecOption<PositionInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(PositionInfo eachRecord : option.recordInfos) {
			SqlStmtExecOption<PositionInfo> stmtExecOption = new SqlStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new PositionStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DecisionResult<PositionInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
