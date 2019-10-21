package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterAreaT01;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneEnforceAreaT01 extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		InfoSetter<PhoneInfo> setterAttr = new PhoneSetterAreaT01();
		return setterAttr.setAttr(recordInfo);
	}
}
