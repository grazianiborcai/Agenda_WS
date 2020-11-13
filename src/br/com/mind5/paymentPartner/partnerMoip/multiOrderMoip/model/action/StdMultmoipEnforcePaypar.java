package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipEnforcePaypar extends ActionStdTemplate<MultmoipInfo> {

	public StdMultmoipEnforcePaypar(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MultmoipInfo> buildVisitorHook(DeciTreeOption<MultmoipInfo> option) {
		return new VisiMultmoipEnforcePaypar(option);
	}
}
