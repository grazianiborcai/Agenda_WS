package br.com.gda.business.phone.model.action;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneSetterNumberT01;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneEnforceNumberT01 extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		PhoneInfo phone = recordInfo;		
		PhoneSetterNumberT01 setterAttr = new PhoneSetterNumberT01();
		return setterAttr.setAttr(phone);
	}
}
