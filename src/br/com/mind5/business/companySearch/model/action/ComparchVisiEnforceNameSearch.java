package br.com.mind5.business.companySearch.model.action;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.info.ComparchSetterNameSearch;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class ComparchVisiEnforceNameSearch extends ActionVisitorTemplateEnforce<ComparchInfo> {
	
	public ComparchVisiEnforceNameSearch(DeciTreeOption<ComparchInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected ComparchInfo enforceHook(ComparchInfo recordInfo) {
		InfoSetter<ComparchInfo> attrSetter = new ComparchSetterNameSearch();
		return attrSetter.setAttr(recordInfo);
	}
}
