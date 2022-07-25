package br.com.mind5.discount.discountStoreSearch.model.action;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchSetterActive;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisorarchVisiEnforceActive extends ActionVisitorTemplateEnforce<DisorarchInfo> {
	
	public DisorarchVisiEnforceActive(DeciTreeOption<DisorarchInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected DisorarchInfo enforceHook(DisorarchInfo recordInfo) {
		InfoSetter<DisorarchInfo> attrSetter = new DisorarchSetterActive();
		return attrSetter.setAttr(recordInfo);
	}
}
