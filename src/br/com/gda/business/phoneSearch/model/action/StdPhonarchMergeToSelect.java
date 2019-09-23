package br.com.gda.business.phoneSearch.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperMerge;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
