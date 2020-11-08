package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipEnforcePayment extends ActionStdTemplateV2<PaymoipInfo> {

	public StdPaymoipEnforcePayment(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PaymoipInfo> buildVisitorHook(DeciTreeOption<PaymoipInfo> option) {
		return new VisiPaymoipEnforcePayment(option);
	}
}
