package br.com.gda.business.form.formAddress.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFormAddressEnforceDefault implements ActionStd<FormAddressInfo> {
	private ActionStd<FormAddressInfo> actionHelper;	
	
	
	public StdFormAddressEnforceDefault(DeciTreeOption<FormAddressInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiFormAddressEnforceDefault());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FormAddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FormAddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
