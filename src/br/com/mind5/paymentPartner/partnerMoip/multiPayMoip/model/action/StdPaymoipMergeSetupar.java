package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class StdPaymoipMergeSetupar extends ActionStdTemplateV2<PaymoipInfo> {

	public StdPaymoipMergeSetupar(DeciTreeOption<PaymoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PaymoipInfo> buildVisitorHook(DeciTreeOption<PaymoipInfo> option) {
		return new VisiPaymoipMergeSetupar(option);
	}
}
