package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMap;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionMapOption;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MapAddressNodeInsert implements ActionStd<AddressInfo> {
	private ActionStd<AddressInfo> actionHelper;	
	
	
	public MapAddressNodeInsert(DeciTreeOption<AddressInfo> option) {			
		actionHelper = new ActionStdHelperMap<AddressInfo, FormAddressInfo>(buildOption(option));
	}
	
	
	
	private ActionMapOption<AddressInfo, FormAddressInfo> buildOption(DeciTreeOption<AddressInfo> treeOption) {
		ActionMapOption<AddressInfo, FormAddressInfo> optionMap = ActionMapOption.copyFromTreeOption(treeOption);
		optionMap.visitorAction = VisimapAddressNodeInsert.class;
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
