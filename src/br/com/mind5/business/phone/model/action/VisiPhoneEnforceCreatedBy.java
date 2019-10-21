package br.com.mind5.business.phone.model.action;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.info.PhoneSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPhoneEnforceCreatedBy extends ActionVisitorTemplateEnforce<PhoneInfo> {
	
	@Override protected PhoneInfo enforceHook(PhoneInfo recordInfo) {
		InfoSetter<PhoneInfo> attrSetter = new PhoneSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
