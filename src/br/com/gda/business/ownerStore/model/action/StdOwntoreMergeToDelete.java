package br.com.gda.business.ownerStore.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdOwntoreMergeToDelete implements ActionStd<OwntoreInfo> {
	private ActionStd<OwntoreInfo> actionHelper;	
	
	
	public StdOwntoreMergeToDelete(DeciTreeOption<OwntoreInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiOwntoreMergeToDelete(option.conn, option.schemaName));
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
