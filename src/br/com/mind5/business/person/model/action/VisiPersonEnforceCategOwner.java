package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterCategOwner;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonEnforceCategOwner extends ActionVisitorTemplateEnforce<PersonInfo> {

	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterCategOwner();
		return attrSetter.setAttr(recordInfo);
	}
}
