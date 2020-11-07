package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipOrdmoipRead extends ActionStdTemplateV2<MultmoipInfo> {

	public StdMultmoipOrdmoipRead(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MultmoipInfo> buildVisitorHook(DeciTreeOption<MultmoipInfo> option) {
		return new VisiMultmoipOrdmoipRead(option);
	}
}
