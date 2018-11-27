package br.com.gda.business.person.model.action;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonSetterLChanged;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonEnforceLChanged extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		PersonSetterLChanged attrSetter = new PersonSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
