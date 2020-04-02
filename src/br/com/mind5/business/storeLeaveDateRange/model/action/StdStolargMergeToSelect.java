package br.com.mind5.business.storeLeaveDateRange.model.action;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolargMergeToSelect implements ActionStdV1<StolargInfo> {
	private ActionStdV1<StolargInfo> actionHelper;	
	
	
	public StdStolargMergeToSelect(DeciTreeOption<StolargInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiStolargMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<StolargInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<StolargInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
