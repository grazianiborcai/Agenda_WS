package br.com.mind5.business.address.model.action;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperAction;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddressInsertAddresnap implements ActionStdV1<AddressInfo> {
	private ActionStdV1<AddressInfo> actionHelper;	
	
	
	public StdAddressInsertAddresnap(DeciTreeOption<AddressInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiAddressInsertAddresnap(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<AddressInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddressInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
