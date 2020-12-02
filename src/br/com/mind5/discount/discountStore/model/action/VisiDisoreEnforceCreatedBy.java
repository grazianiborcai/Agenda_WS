package br.com.mind5.discount.discountStore.model.action;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisoreEnforceCreatedBy extends ActionVisitorTemplateEnforce<DisoreInfo> {
	
	public VisiDisoreEnforceCreatedBy(DeciTreeOption<DisoreInfo> option) {
		super(option);	
	}
	
	
	
	
	@Override protected DisoreInfo enforceHook(DisoreInfo recordInfo) {
		InfoSetter<DisoreInfo> attrSetter = new DisoreSetterCreatedBy();
		return attrSetter.setAttr(recordInfo);
	}
}
