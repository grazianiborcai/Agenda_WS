package br.com.gda.business.phone.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMap;
import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionMapOption;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MapPhoneMergeForm implements ActionStd<PhoneInfo> {
	private ActionStd<PhoneInfo> actionHelper;	
	
	
	public MapPhoneMergeForm(DeciTreeOption<PhoneInfo> option) {			
		actionHelper = new ActionStdHelperMap<PhoneInfo, FormPhoneInfo>(buildOption(option));
	}
	
	
	
	private ActionMapOption<PhoneInfo, FormPhoneInfo> buildOption(DeciTreeOption<PhoneInfo> treeOption) {
		ActionMapOption<PhoneInfo, FormPhoneInfo> optionMap = ActionMapOption.copyFromTreeOption(treeOption);
		optionMap.visitorAction = VisimapPhoneMergeForm.class;
		optionMap.visitorMap = VisimapPhoneFormKey.class;
		
		return optionMap;
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
