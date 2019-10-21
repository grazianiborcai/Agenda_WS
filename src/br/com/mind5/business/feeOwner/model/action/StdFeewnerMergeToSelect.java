package br.com.mind5.business.feeOwner.model.action;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeewnerMergeToSelect implements ActionStd<FeewnerInfo> {
	private ActionStd<FeewnerInfo> actionHelper;	
	
	
	public StdFeewnerMergeToSelect(DeciTreeOption<FeewnerInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFeewnerMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<FeewnerInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<FeewnerInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
