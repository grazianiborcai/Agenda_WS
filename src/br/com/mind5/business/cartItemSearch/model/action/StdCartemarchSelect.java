package br.com.mind5.business.cartItemSearch.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItemSearch.dao.CartemarchSelect;
import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperStmt;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemarchSelect implements ActionStd<CartemarchInfo> {
	private ActionStd<CartemarchInfo> actionHelper;
	
	
	public StdCartemarchSelect(DeciTreeOption<CartemarchInfo> option) {
		DaoStmtExec_<CartemarchInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmt<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CartemarchInfo> buildStmtExec(DeciTreeOption<CartemarchInfo> option) {
		List<DaoStmtExecOption<CartemarchInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CartemarchInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CartemarchInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CartemarchSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartemarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartemarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
