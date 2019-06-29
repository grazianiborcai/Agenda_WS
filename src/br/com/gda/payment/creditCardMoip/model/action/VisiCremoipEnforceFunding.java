package br.com.gda.payment.creditCardMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.creditCardMoip.info.CremoipSetterFunding;

final class VisiCremoipEnforceFunding extends ActionVisitorTemplateEnforce<CremoipInfo> {
	
	@Override protected CremoipInfo enforceHook(CremoipInfo recordInfo) {
		InfoSetter<CremoipInfo> setter = new CremoipSetterFunding();
		return setter.setAttr(recordInfo);
	}
}
