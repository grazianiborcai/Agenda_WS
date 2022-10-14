package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterGenderDefault;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiEnforceGenderDefault extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	public PersonVisiEnforceGenderDefault(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterGenderDefault();
		return attrSetter.setAttr(recordInfo);
	}
}
