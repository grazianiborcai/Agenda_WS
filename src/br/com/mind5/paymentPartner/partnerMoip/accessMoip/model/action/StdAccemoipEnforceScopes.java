package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class StdAccemoipEnforceScopes extends ActionStdTemplate<AccemoipInfo> {

	public StdAccemoipEnforceScopes(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AccemoipInfo> buildVisitorHook(DeciTreeOption<AccemoipInfo> option) {
		return new VisiAccemoipEnforceScopes(option);
	}
}
