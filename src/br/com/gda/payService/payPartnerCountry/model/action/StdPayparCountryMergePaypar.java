package br.com.gda.payService.payPartnerCountry.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;

public final class StdPayparCountryMergePaypar implements ActionStd<PayparCountryInfo> {
	private ActionStd<PayparCountryInfo> actionHelper;	
	
	
	public StdPayparCountryMergePaypar(DeciTreeOption<PayparCountryInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayparCountryMergePaypar(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayparCountryInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayparCountryInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
