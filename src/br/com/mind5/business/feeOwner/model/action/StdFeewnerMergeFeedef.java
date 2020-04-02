package br.com.mind5.business.feeOwner.model.action;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeewnerMergeFeedef implements ActionStdV1<FeewnerInfo> {
	private ActionStdV1<FeewnerInfo> actionHelper;	
	
	
	public StdFeewnerMergeFeedef(DeciTreeOption<FeewnerInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFeewnerMergeFeedef(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazyV1<FeewnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeewnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
