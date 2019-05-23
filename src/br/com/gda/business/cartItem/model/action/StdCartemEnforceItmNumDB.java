package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartemEnforceItmNumDB implements ActionStd<CartemInfo> {
	private ActionStd<CartemInfo> actionHelper;	
	
	
	public StdCartemEnforceItmNumDB(DeciTreeOption<CartemInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCartemEnforceItmNumDB(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartemInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartemInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
