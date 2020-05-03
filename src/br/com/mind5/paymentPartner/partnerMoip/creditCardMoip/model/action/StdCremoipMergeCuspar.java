package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;

public final class StdCremoipMergeCuspar extends ActionStdTemplateV2<CremoipInfo> {

	public StdCremoipMergeCuspar(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CremoipInfo> buildVisitorHook(DeciTreeOption<CremoipInfo> option) {
		return new VisiCremoipMergeCuspar(option);
	}
}
