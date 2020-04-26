package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemSetterCreatedOn;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemEnforceCreatedOn extends ActionVisitorTemplateEnforceV2<CartemInfo> {
	
	public VisiCartemEnforceCreatedOn(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterCreatedOn();
		return setter.setAttr(recordInfo);
	}
}
