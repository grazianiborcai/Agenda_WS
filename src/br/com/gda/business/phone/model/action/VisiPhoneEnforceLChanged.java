package br.com.gda.business.phone.model.action;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.info.PhoneSetterLChanged;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneEnforceLChanged extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		PhoneSetterLChanged attrSetter = new PhoneSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
