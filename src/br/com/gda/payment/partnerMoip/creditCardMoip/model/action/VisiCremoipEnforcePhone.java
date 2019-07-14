package br.com.gda.payment.partnerMoip.creditCardMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.partnerMoip.creditCardMoip.info.CremoipSetterPhone;

final class VisiCremoipEnforcePhone extends ActionVisitorTemplateEnforce<CremoipInfo> {
	
	@Override protected CremoipInfo enforceHook(CremoipInfo recordInfo) {
		InfoSetter<CremoipInfo> setter = new CremoipSetterPhone();
		return setter.setAttr(recordInfo);
	}
}
