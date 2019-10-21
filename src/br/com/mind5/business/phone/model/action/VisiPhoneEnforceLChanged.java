package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneEnforceLChanged extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		InfoSetter<PhoneInfo> attrSetter = new PhoneSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
