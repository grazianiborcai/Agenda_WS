package br.com.gda.business.personCustomer.model.action;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.info.PersonCusSetterCodEntityCateg;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonCusEnforceEntityCateg extends ActionVisitorTemplateEnforce<PersonCusInfo> {
	
	@Override protected PersonCusInfo enforceHook(PersonCusInfo recordInfo) {
		InfoSetter<PersonCusInfo> attrSetter = new PersonCusSetterCodEntityCateg();
		return attrSetter.setAttr(recordInfo);
	}
}
