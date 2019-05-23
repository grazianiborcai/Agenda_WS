package br.com.gda.business.cartItem.model.action;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCartemMergeFeetore implements ActionStd<CartemInfo> {
	private ActionStd<CartemInfo> actionHelper;	
	
	
	public StdCartemMergeFeetore(DeciTreeOption<CartemInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCartemMergeFeetore(option.conn, option.schemaName));
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
