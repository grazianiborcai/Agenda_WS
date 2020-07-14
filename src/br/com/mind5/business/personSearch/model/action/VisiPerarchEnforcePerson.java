package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchSetterPerson;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerarchEnforcePerson extends ActionVisitorTemplateEnforceV2<PerarchInfo> {
	
	public VisiPerarchEnforcePerson(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PerarchInfo enforceHook(PerarchInfo recordInfo) {
		InfoSetter<PerarchInfo> attrSetter = new PerarchSetterPerson();
		return attrSetter.setAttr(recordInfo);
	}
}
