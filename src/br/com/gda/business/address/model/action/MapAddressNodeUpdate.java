package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMap;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionMapOption;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MapAddressNodeUpdate implements ActionStd<AddressInfo> {
	private ActionStd<AddressInfo> actionHelper;	
	
	
	public MapAddressNodeUpdate(DeciTreeOption<AddressInfo> option) {			
		actionHelper = new ActionStdHelperMap<AddressInfo, AddressFormInfo>(buildOption(option));
	}
	
	
	
	private ActionMapOption<AddressInfo, AddressFormInfo> buildOption(DeciTreeOption<AddressInfo> treeOption) {
		ActionMapOption<AddressInfo, AddressFormInfo> optionMap = ActionMapOption.copyFromTreeOption(treeOption);
		optionMap.visitorAction = VisimapAddressNodeUpdate.class;
		optionMap.visitorMap = VisimapAddressFormKey.class;
		
		return optionMap;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
