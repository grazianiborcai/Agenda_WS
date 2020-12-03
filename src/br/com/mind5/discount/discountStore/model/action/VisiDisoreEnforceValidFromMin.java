package br.com.mind5.discount.discountStore.model.action;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreSetterValidFromMin;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoreEnforceValidFromMin extends ActionVisitorTemplateEnforce<DisoreInfo> {
	
	public VisiDisoreEnforceValidFromMin(DeciTreeOption<DisoreInfo> option) {
		super(option);	
	}
	
	
	
	
	@Override protected DisoreInfo enforceHook(DisoreInfo recordInfo) {
		InfoSetter<DisoreInfo> attrSetter = new DisoreSetterValidFromMin();
		return attrSetter.setAttr(recordInfo);
	}
}
