package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressEnforceLChanged implements ActionStd<AddressInfo> {
	private ActionStd<AddressInfo> actionHelper;	
	
	
	public StdAddressEnforceLChanged(DeciTreeOption<AddressInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiAddressEnforceLChanged());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
