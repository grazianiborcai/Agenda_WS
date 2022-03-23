package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemSetterAged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemVisiEnforceAged extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	public CartemVisiEnforceAged(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterAged();
		return setter.setAttr(recordInfo);
	}
}
