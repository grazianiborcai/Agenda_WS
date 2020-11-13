package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemSetterSymsgL13;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemEnforceSymsgL13 extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	public VisiCartemEnforceSymsgL13(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterSymsgL13();
		return setter.setAttr(recordInfo);
	}
}
