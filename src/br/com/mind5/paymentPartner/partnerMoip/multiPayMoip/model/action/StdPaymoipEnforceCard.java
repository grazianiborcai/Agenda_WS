package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipEnforceCard extends ActionStdTemplate<PaymoipInfo> {

	public StdPaymoipEnforceCard(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PaymoipInfo> buildVisitorHook(DeciTreeOption<PaymoipInfo> option) {
		return new VisiPaymoipEnforceCard(option);
	}
}
