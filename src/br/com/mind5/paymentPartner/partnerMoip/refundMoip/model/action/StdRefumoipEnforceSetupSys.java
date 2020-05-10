package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StdRefumoipEnforceSetupSys extends ActionStdTemplateV2<RefumoipInfo> {

	public StdRefumoipEnforceSetupSys(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefumoipInfo> buildVisitorHook(DeciTreeOption<RefumoipInfo> option) {
		return new VisiRefumoipEnforceSetupSys(option);
	}
}
