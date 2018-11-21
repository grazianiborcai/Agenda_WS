package br.com.gda.business.phone.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMap;
import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionMapOption;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MapPhoneNodeInsert implements ActionStd<PhoneInfo> {
	private ActionStd<PhoneInfo> actionHelper;	
	
	
	public MapPhoneNodeInsert(DeciTreeOption<PhoneInfo> option) {			
		actionHelper = new ActionStdHelperMap<PhoneInfo, CountryPhoneInfo>(buildOption(option));
	}
	
	
	
	private ActionMapOption<PhoneInfo, CountryPhoneInfo> buildOption(DeciTreeOption<PhoneInfo> treeOption) {
		ActionMapOption<PhoneInfo, CountryPhoneInfo> optionMap = ActionMapOption.copyFromTreeOption(treeOption);
		optionMap.visitorAction = VisimapPhoneNodeInsert.class;
		optionMap.visitorMap = VisimapPhoneBucket.class;
		
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
