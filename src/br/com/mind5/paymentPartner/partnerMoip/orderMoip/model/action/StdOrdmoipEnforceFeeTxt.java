package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class StdOrdmoipEnforceFeeTxt extends ActionStdTemplateV2<OrdmoipInfo> {

	public StdOrdmoipEnforceFeeTxt(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrdmoipInfo> buildVisitorHook(DeciTreeOption<OrdmoipInfo> option) {
		return new VisiOrdmoipEnforceFeeTxt(option);
	}
}
