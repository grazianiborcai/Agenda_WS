package br.com.gda.business.phone.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhoneEnforceLChanged implements ActionStd<PhoneInfo> {
	private ActionStd<PhoneInfo> actionHelper;	
	
	
	public StdPhoneEnforceLChanged(DeciTreeOption<PhoneInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPhoneEnforceLChanged());
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
