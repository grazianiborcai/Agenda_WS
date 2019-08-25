package br.com.gda.business.orderSnapshot.model.action;

import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOrdnapMergeUselis implements ActionStd<OrdnapInfo> {
	private ActionStd<OrdnapInfo> actionHelper;	
	
	
	public StdOrdnapMergeUselis(DeciTreeOption<OrdnapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOrdnapMergeUselis(option.conn, option.schemaName));
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
