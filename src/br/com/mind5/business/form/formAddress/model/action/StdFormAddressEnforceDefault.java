package br.com.mind5.business.form.formAddress.model.action;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperEnforce;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

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
