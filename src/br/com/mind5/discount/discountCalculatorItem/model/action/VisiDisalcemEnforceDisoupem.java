package br.com.mind5.discount.discountCalculatorItem.model.action;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemSetterDisoupem;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiDisalcemEnforceDisoupem extends ActionVisitorTemplateEnforce<DisalcemInfo> {
	
	public VisiDisalcemEnforceDisoupem(DeciTreeOption<DisalcemInfo> option) {
		super(option);	
	}
	
	
	
	
	@Override protected DisalcemInfo enforceHook(DisalcemInfo recordInfo) {
		InfoSetter<DisalcemInfo> attrSetter = new DisalcemSetterDisoupem();
		return attrSetter.setAttr(recordInfo);
	}
}
