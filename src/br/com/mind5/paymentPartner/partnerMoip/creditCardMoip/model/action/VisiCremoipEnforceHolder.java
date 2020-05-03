package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipSetterHolder;

final class VisiCremoipEnforceHolder extends ActionVisitorTemplateEnforceV2<CremoipInfo> {
	
	public VisiCremoipEnforceHolder(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CremoipInfo enforceHook(CremoipInfo recordInfo) {
		InfoSetter<CremoipInfo> setter = new CremoipSetterHolder();
		return setter.setAttr(recordInfo);
	}
}
