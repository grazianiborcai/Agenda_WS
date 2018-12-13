package br.com.gda.business.phoneSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMap;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionMapOption;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MapPhoneSnapMergeForm implements ActionStd<PhoneSnapInfo> {
	private ActionStd<PhoneSnapInfo> actionHelper;	
	
	
	public MapPhoneSnapMergeForm(DeciTreeOption<PhoneSnapInfo> option) {			
		actionHelper = new ActionStdHelperMap<PhoneSnapInfo, CountryPhoneInfo>(buildOption(option));
	}
	
	
	
	private ActionMapOption<PhoneSnapInfo, CountryPhoneInfo> buildOption(DeciTreeOption<PhoneSnapInfo> treeOption) {
		ActionMapOption<PhoneSnapInfo, CountryPhoneInfo> optionMap = ActionMapOption.copyFromTreeOption(treeOption);
		optionMap.visitorAction = VisimapPhoneSnapMergeForm.class;
		optionMap.visitorMap = VisimapPhoneSnapBucket.class;
		
		return optionMap;
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
