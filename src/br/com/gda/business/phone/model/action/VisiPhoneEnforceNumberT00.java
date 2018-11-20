package br.com.gda.business.phone.model.action;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneSetterNumberT00;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneEnforceNumberT00 extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		PhoneInfo phone = recordInfo;		
		PhoneSetterNumberT00 setterAttr = new PhoneSetterNumberT00();
		return setterAttr.setAttr(phone);
	}
}
