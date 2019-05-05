package br.com.gda.business.address.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressMergeCountry implements ActionStd<AddressInfo> {
	private ActionStd<AddressInfo> actionHelper;	
	
	
	public StdAddressMergeCountry(DeciTreeOption<AddressInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiAddressMergeCountry(option.conn, option.schemaName));
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
