package br.com.gda.payment.creditCardMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.creditCardMoip.info.CremoipInfo;
import br.com.gda.payment.creditCardMoip.info.CremoipSetterHolder;

final class VisiCremoipEnforceHolder extends ActionVisitorTemplateEnforce<CremoipInfo> {
	
	@Override protected CremoipInfo enforceHook(CremoipInfo recordInfo) {
		InfoSetter<CremoipInfo> setter = new CremoipSetterHolder();
		return setter.setAttr(recordInfo);
	}
}
