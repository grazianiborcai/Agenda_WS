package br.com.gda.business.ownerStore_.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperAction;
import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOwntoreDeleteStore implements ActionStd<OwntoreInfo> {
	private ActionStd<OwntoreInfo> actionHelper;	
	
	
	public StdOwntoreDeleteStore(DeciTreeOption<OwntoreInfo> option) {			
		actionHelper = new ActionStdHelperAction<>(option.recordInfos, new VisiOwntoreDeleteStore(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<OwntoreInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<OwntoreInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
