package br.com.gda.business.cartReserve.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCarterveEnforceLChanged implements ActionStd<CarterveInfo> {
	private ActionStd<CarterveInfo> actionHelper;	
	
	
	public StdCarterveEnforceLChanged(DeciTreeOption<CarterveInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiCarterveEnforceLChanged());
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
