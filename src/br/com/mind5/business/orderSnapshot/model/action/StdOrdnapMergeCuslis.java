package br.com.mind5.business.orderSnapshot.model.action;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdnapMergeCuslis implements ActionStd<OrdnapInfo> {
	private ActionStd<OrdnapInfo> actionHelper;	
	
	
	public StdOrdnapMergeCuslis(DeciTreeOption<OrdnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdnapMergeCuslis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OrdnapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OrdnapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
