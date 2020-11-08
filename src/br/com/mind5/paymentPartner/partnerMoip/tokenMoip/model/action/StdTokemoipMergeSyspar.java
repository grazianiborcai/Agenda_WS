package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class StdTokemoipMergeSyspar extends ActionStdTemplateV2<TokemoipInfo> {

	public StdTokemoipMergeSyspar(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<TokemoipInfo> buildVisitorHook(DeciTreeOption<TokemoipInfo> option) {
		return new VisiTokemoipMergeSyspar(option);
	}
}
