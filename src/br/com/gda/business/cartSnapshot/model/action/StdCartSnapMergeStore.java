package br.com.gda.business.cartSnapshot.model.action;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartSnapMergeStore implements ActionStd<CartSnapInfo> {
	private ActionStd<CartSnapInfo> actionHelper;	
	
	
	public StdCartSnapMergeStore(DeciTreeOption<CartSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCartSnapMergeStore(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CartSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CartSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
