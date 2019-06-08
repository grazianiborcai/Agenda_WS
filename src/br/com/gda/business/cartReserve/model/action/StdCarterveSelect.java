package br.com.gda.business.cartReserve.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.cartReserve.dao.CarterveSelect;
import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperStmt;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCarterveSelect implements ActionStd<CarterveInfo> {
	private ActionStd<CarterveInfo> actionHelper;
	
	
	public StdCarterveSelect(DeciTreeOption<CarterveInfo> option) {
		DaoStmtExec<CarterveInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec<CarterveInfo> buildStmtExec(DeciTreeOption<CarterveInfo> option) {
		List<DaoStmtExecOption<CarterveInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CarterveInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CarterveInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CarterveSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CarterveInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CarterveInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
