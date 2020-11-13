package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class StdRefumoipEnforceSetupNonsys extends ActionStdTemplate<RefumoipInfo> {

	public StdRefumoipEnforceSetupNonsys(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefumoipInfo> buildVisitorHook(DeciTreeOption<RefumoipInfo> option) {
		return new VisiRefumoipEnforceSetupNonsys(option);
	}
}
