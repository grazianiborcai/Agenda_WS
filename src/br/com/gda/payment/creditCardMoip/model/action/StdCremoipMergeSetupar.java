package br.com.gda.payment.creditCardMoip.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;

public final class StdCremoipMergeSetupar implements ActionStd<CremoipInfo> {
	private ActionStd<CremoipInfo> actionHelper;	
	
	
	public StdCremoipMergeSetupar(DeciTreeOption<CremoipInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiCremoipMergeSetupar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<CremoipInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<CremoipInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
