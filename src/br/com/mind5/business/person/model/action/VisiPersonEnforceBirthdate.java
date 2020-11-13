package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterBirthdate;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonEnforceBirthdate extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	public VisiPersonEnforceBirthdate(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	

	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterBirthdate();
		return attrSetter.setAttr(recordInfo);
	}
}
