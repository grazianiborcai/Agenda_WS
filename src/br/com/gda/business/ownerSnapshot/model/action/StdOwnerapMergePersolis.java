package br.com.gda.business.ownerSnapshot.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOwnerapMergePersolis implements ActionStd<OwnerapInfo> {
	private ActionStd<OwnerapInfo> actionHelper;	
	
	
	public StdOwnerapMergePersolis(DeciTreeOption<OwnerapInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiOwnerapMergePersolis(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwnerapInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwnerapInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
