package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class StdMultmoipOrdmoipPlace extends ActionStdTemplate<MultmoipInfo> {

	public StdMultmoipOrdmoipPlace(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MultmoipInfo> buildVisitorHook(DeciTreeOption<MultmoipInfo> option) {
		return new VisiMultmoipOrdmoipPlace(option);
	}
}
