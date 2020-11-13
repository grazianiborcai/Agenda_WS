package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class StdCusmoipEnforceAddress extends ActionStdTemplate<CusmoipInfo> {

	public StdCusmoipEnforceAddress(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusmoipInfo> buildVisitorHook(DeciTreeOption<CusmoipInfo> option) {
		return new VisiCusmoipEnforceAddress(option);
	}
}
