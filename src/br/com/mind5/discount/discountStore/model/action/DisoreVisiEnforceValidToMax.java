package br.com.mind5.discount.discountStore.model.action;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.info.DisoreSetterValidToMax;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class DisoreVisiEnforceValidToMax extends ActionVisitorTemplateEnforce<DisoreInfo> {
	
	public DisoreVisiEnforceValidToMax(DeciTreeOption<DisoreInfo> option) {
		super(option);	
	}
	
	
	
	
	@Override protected DisoreInfo enforceHook(DisoreInfo recordInfo) {
		InfoSetter<DisoreInfo> attrSetter = new DisoreSetterValidToMax();
		return attrSetter.setAttr(recordInfo);
	}
}
