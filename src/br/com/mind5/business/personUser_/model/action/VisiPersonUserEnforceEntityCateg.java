package br.com.mind5.business.personUser_.model.action;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.business.personUser_.info.PersonUserSetterCodEntityCateg;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonUserEnforceEntityCateg extends ActionVisitorTemplateEnforce<PersonUserInfo> {
	
	@Override protected PersonUserInfo enforceHook(PersonUserInfo recordInfo) {
		InfoSetter<PersonUserInfo> attrSetter = new PersonUserSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
