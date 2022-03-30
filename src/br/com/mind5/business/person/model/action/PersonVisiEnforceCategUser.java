package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterCategUser;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiEnforceCategUser extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	public PersonVisiEnforceCategUser(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	

	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterCategUser();
		return attrSetter.setAttr(recordInfo);
	}
}
