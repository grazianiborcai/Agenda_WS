package br.com.gda.business.addressSnapshot.model.action;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMap;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionMapOption;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MapAddressSnapMergeForm implements ActionStd<AddressSnapInfo> {
	private ActionStd<AddressSnapInfo> actionHelper;	
	
	
	public MapAddressSnapMergeForm(DeciTreeOption<AddressSnapInfo> option) {			
		actionHelper = new ActionStdHelperMap<AddressSnapInfo, FormAddressInfo>(buildOption(option));
	}
	
	
	
	private ActionMapOption<AddressSnapInfo, FormAddressInfo> buildOption(DeciTreeOption<AddressSnapInfo> treeOption) {
		ActionMapOption<AddressSnapInfo, FormAddressInfo> optionMap = ActionMapOption.copyFromTreeOption(treeOption);
		optionMap.visitorAction = VisimapAddressSnapMergeForm.class;
		optionMap.visitorMap = VisimapAddressSnapFormKey.class;
		
		return optionMap;
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddressSnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressSnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
