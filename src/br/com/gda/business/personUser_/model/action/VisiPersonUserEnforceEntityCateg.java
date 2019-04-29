package br.com.gda.business.personUser_.model.action;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.business.personUser_.info.PersonUserSetterCodEntityCateg;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonUserEnforceEntityCateg extends ActionVisitorTemplateEnforce<PersonUserInfo> {
	
	@Override protected PersonUserInfo enforceHook(PersonUserInfo recordInfo) {
		InfoSetter<PersonUserInfo> attrSetter = new PersonUserSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
