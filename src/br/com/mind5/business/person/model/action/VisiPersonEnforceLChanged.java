package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonEnforceLChanged extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
