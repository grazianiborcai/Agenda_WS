package br.com.mind5.business.addressSnapshot.model.action;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAddresnapMergeEmplis implements ActionStd<AddresnapInfo> {
	private ActionStd<AddresnapInfo> actionHelper;	
	
	
	public StdAddresnapMergeEmplis(DeciTreeOption<AddresnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiAddresnapMergeEmplis(option.conn, option.schemaName));
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
