package br.com.gda.business.addressSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdAddresnapMergeCuslis implements ActionStd<AddresnapInfo> {
	private ActionStd<AddresnapInfo> actionHelper;	
	
	
	public StdAddresnapMergeCuslis(DeciTreeOption<AddresnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiAddresnapMergeCuslis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<AddresnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<AddresnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
