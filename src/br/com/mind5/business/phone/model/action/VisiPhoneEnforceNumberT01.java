package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterNumberT01;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneEnforceNumberT01 extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		PhoneInfo phone = recordInfo;		
		InfoSetter<PhoneInfo> setterAttr = new PhoneSetterNumberT01();
		return setterAttr.setAttr(phone);
	}
}
