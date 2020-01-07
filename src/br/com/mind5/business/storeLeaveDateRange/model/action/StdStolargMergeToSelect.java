package br.com.mind5.business.storeLeaveDateRange.model.action;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolargMergeToSelect implements ActionStd<StolargInfo> {
	private ActionStd<StolargInfo> actionHelper;	
	
	
	public StdStolargMergeToSelect(DeciTreeOption<StolargInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStolargMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<StolargInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolargInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
