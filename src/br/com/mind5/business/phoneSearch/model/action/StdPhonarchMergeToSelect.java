package br.com.mind5.business.phoneSearch.model.action;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionStdHelperMerge;
import br.com.mind5.model.decisionTree.DeciResult;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonarchMergeToSelect implements ActionStd<PhonarchInfo> {
	private ActionStd<PhonarchInfo> actionHelper;	
	
	
	public StdPhonarchMergeToSelect(DeciTreeOption<PhonarchInfo> option) {			
		actionHelper = new ActionStdHelperMerge<>(option.recordInfos, new VisiPhonarchMergeToSelect(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PhonarchInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PhonarchInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
