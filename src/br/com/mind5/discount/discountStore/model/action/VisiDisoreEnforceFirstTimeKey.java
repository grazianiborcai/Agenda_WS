package br.com.mind5.discount.discountStore.model.action;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreSetterFirstTimeKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoreEnforceFirstTimeKey extends ActionVisitorTemplateEnforce<DisoreInfo> {
	
	public VisiDisoreEnforceFirstTimeKey(DeciTreeOption<DisoreInfo> option) {
		super(option);	
	}
	
	
	
	@Override protected DisoreInfo enforceHook(DisoreInfo recordInfo) {
		InfoSetter<DisoreInfo> attrSetter = new DisoreSetterFirstTimeKey();
		return attrSetter.setAttr(recordInfo);
	}
}
