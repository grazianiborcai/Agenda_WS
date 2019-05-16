package br.com.gda.business.address.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddressInsertAddresnap implements ActionStd<AddressInfo> {
	private ActionStd<AddressInfo> actionHelper;	
	
	
	public StdAddressInsertAddresnap(DeciTreeOption<AddressInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiAddressInsertAddresnap(option.conn, option.schemaName));
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
