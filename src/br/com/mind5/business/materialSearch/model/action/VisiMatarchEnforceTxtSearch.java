package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.info.MatarchSetterTxtSearch;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatarchEnforceTxtSearch extends ActionVisitorTemplateEnforce<MatarchInfo> {
	
	public VisiMatarchEnforceTxtSearch(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatarchInfo enforceHook(MatarchInfo recordInfo) {
		InfoSetter<MatarchInfo> attrSetter = new MatarchSetterTxtSearch();
		return attrSetter.setAttr(recordInfo);
	}
}
