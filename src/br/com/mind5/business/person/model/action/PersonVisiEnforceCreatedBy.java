package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiEnforceCreatedBy extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	public PersonVisiEnforceCreatedBy(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
