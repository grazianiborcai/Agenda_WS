package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;

public final class StdCusmoipMergeUserap extends ActionStdTemplateV2<CusmoipInfo> {

	public StdCusmoipMergeUserap(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CusmoipInfo> buildVisitorHook(DeciTreeOption<CusmoipInfo> option) {
		return new VisiCusmoipMergeUserap(option);
	}
}
