package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.info.PerarchSetterNameSearch;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPerarchEnforceNameSearch extends ActionVisitorTemplateEnforce<PerarchInfo> {
	
	public VisiPerarchEnforceNameSearch(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PerarchInfo enforceHook(PerarchInfo recordInfo) {
		InfoSetter<PerarchInfo> attrSetter = new PerarchSetterNameSearch();
		return attrSetter.setAttr(recordInfo);
	}
}
