package br.com.mind5.business.cartReserve.model.action;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.info.CarterveSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCarterveEnforceLChanged extends ActionVisitorTemplateEnforce<CarterveInfo> {
	
	public VisiCarterveEnforceLChanged(DeciTreeOption<CarterveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CarterveInfo enforceHook(CarterveInfo recordInfo) {
		InfoSetter<CarterveInfo> setter = new CarterveSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
