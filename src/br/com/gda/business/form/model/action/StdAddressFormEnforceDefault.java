package br.com.gda.business.form.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressFormEnforceDefault implements ActionStd<AddressFormInfo> {
	private ActionStd<AddressFormInfo> actionHelper;	
	
	
	public StdAddressFormEnforceDefault(DeciTreeOption<AddressFormInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiAddressFormEnforceDefault());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddressFormInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressFormInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
