package br.com.gda.business.form.formPhone.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFormPhoneEnforceDefault implements ActionStd<FormPhoneInfo> {
	private ActionStd<FormPhoneInfo> actionHelper;	
	
	
	public StdFormPhoneEnforceDefault(DeciTreeOption<FormPhoneInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiFormPhoneEnforceDefault());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FormPhoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FormPhoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
