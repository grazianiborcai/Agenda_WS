package br.com.gda.payService.payPartnerCountry.model.action;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStdHelperEnforce;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;

public final class StdPayPartnerCountryMergePayPartner implements ActionStd<PayPartnerCountryInfo> {
	private ActionStd<PayPartnerCountryInfo> actionHelper;	
	
	
	public StdPayPartnerCountryMergePayPartner(DeciTreeOption<PayPartnerCountryInfo> option) {			
		actionHelper = new ActionStdHelperEnforce<>(option.recordInfos, new VisiPayPartnerCountryMergePayPartner(option.conn, option.schemaName));
	}
	
	
	
	@Override public void addPostAction(ActionLazy<PayPartnerCountryInfo> actionHandler) {
		actionHelper.addPostAction(actionHandler);
	}
	
	
	
	@Override public boolean executeAction() {			
		return actionHelper.executeAction();
	}
	
	
	
	@Override public DeciResult<PayPartnerCountryInfo> getDecisionResult() {
		return actionHelper.getDecisionResult();
	}
}
