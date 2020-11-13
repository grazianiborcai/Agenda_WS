package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipMergeSysenv extends ActionStdTemplate<MultmoipInfo> {

	public StdMultmoipMergeSysenv(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MultmoipInfo> buildVisitorHook(DeciTreeOption<MultmoipInfo> option) {
		return new VisiMultmoipMergeSysenv(option);
	}
}
