package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterCategEmp;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonEnforceCategEmp extends ActionVisitorTemplateEnforceV2<PersonInfo> {
	
	public VisiPersonEnforceCategEmp(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	

	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterCategEmp();
		return attrSetter.setAttr(recordInfo);
	}
}
