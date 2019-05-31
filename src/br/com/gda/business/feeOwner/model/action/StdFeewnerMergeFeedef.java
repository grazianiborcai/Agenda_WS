package br.com.gda.business.feeOwner.model.action;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdFeewnerMergeFeedef implements ActionStd<FeewnerInfo> {
	private ActionStd<FeewnerInfo> actionHelper;	
	
	
	public StdFeewnerMergeFeedef(DeciTreeOption<FeewnerInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiFeewnerMergeFeedef(option.conn, option.schemaName));
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
