package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemSetterSymsgL12;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemEnforceSymsgL12 extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	public VisiCartemEnforceSymsgL12(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterSymsgL12();
		return setter.setAttr(recordInfo);
	}
}
