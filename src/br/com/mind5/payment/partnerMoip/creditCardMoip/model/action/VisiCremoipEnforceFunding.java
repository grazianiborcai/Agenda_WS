package br.com.mind5.payment.partnerMoip.creditCardMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.payment.partnerMoip.creditCardMoip.info.CremoipSetterFunding;

final class VisiCremoipEnforceFunding extends ActionVisitorTemplateEnforce<CremoipInfo> {
	
	@Override protected CremoipInfo enforceHook(CremoipInfo recordInfo) {
		InfoSetter<CremoipInfo> setter = new CremoipSetterFunding();
		return setter.setAttr(recordInfo);
	}
}
