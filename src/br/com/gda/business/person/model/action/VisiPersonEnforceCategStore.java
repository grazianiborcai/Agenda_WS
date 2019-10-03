package br.com.gda.business.person.model.action;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonSetterCategStore;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiPersonEnforceCategStore extends ActionVisitorTemplateEnforce<PersonInfo> {

	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterCategStore();
		return attrSetter.setAttr(recordInfo);
	}
}
