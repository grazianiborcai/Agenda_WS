package br.com.gda.business.phoneSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhoneSnapMergeForm implements ActionStd<PhoneSnapInfo> {
	private ActionStd<PhoneSnapInfo> actionHelper;	
	
	
	public StdPhoneSnapMergeForm(DeciTreeOption<PhoneSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPhoneSnapMergeForm(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhoneSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhoneSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
