package br.com.gda.business.phone.model.action;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneSetterAll;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneSetAttrAll extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		PhoneInfo phone = recordInfo;		
		PhoneSetterAll setterAttr = new PhoneSetterAll();
		return setterAttr.setAttr(phone);
	}
}
