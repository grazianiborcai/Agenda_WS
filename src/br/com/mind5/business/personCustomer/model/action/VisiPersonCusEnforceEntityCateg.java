package br.com.mind5.business.personCustomer.model.action;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.business.personCustomer.info.PersonCusSetterCodEntityCateg;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonCusEnforceEntityCateg extends ActionVisitorTemplateEnforce<PersonCusInfo> {
	
	@Override protected PersonCusInfo enforceHook(PersonCusInfo recordInfo) {
		InfoSetter<PersonCusInfo> attrSetter = new PersonCusSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
