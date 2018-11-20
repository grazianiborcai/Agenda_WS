package br.com.gda.business.phone.model.action;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhoneEnforceNumberT01 implements ActionStd<PhoneInfo> {
	private ActionStd<PhoneInfo> actionHelper;	
	
	
	public StdPhoneEnforceNumberT01(DeciTreeOption<PhoneInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPhoneEnforceNumberT01());
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhoneInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhoneInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
