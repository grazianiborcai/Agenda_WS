package br.com.mind5.discount.discountStoreSearch.model.action;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchSetterValidFrom;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisorarchEnforceValidFrom extends ActionVisitorTemplateEnforce<DisorarchInfo> {
	
	public VisiDisorarchEnforceValidFrom(DeciTreeOption<DisorarchInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected DisorarchInfo enforceHook(DisorarchInfo recordInfo) {
		InfoSetter<DisorarchInfo> attrSetter = new DisorarchSetterValidFrom();
		return attrSetter.setAttr(recordInfo);
	}
}
