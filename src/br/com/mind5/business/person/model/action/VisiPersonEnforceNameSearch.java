package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonSetterNameSearch;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonEnforceNameSearch extends ActionVisitorTemplateEnforce<PersonInfo> {
	
	public VisiPersonEnforceNameSearch(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PersonInfo enforceHook(PersonInfo recordInfo) {
		InfoSetter<PersonInfo> attrSetter = new PersonSetterNameSearch();
		return attrSetter.setAttr(recordInfo);
	}
}
