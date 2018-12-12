package br.com.gda.business.addressSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressSnapMergeForm implements ActionStd<AddressSnapInfo> {
	private ActionStd<AddressSnapInfo> actionHelper;	
	
	
	public StdAddressSnapMergeForm(DeciTreeOption<AddressSnapInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiAddressSnapMergeForm(option.conn, option.schemaName));
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
