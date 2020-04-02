package br.com.mind5.business.cartItem.model.action;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.dao.CartemSelect;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperStmtV1;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartemSelect implements ActionStdV1<CartemInfo> {
	private ActionStdV1<CartemInfo> actionHelper;
	
	
	public StdCartemSelect(DeciTreeOption<CartemInfo> option) {
		DaoStmtExec_<CartemInfo> sqlStmtExecutor = buildStmtExec(option);
		actionHelper = new ActionStdHelperStmtV1<>(sqlStmtExecutor);
	}
	
	
	
	private DaoStmtExec_<CartemInfo> buildStmtExec(DeciTreeOption<CartemInfo> option) {
		List<DaoStmtExecOption<CartemInfo>> stmtExecOptions = new ArrayList<>();			
		
		for(CartemInfo eachRecord : option.recordInfos) {
			DaoStmtExecOption<CartemInfo> stmtExecOption = new DaoStmtExecOption<>();
			stmtExecOption.conn = option.conn;
			stmtExecOption.recordInfo = eachRecord;
			stmtExecOption.schemaName = option.schemaName;
			stmtExecOptions.add(stmtExecOption);
		}
		
		return new CartemSelect(stmtExecOptions);
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<CartemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
