package br.com.mind5.business.cartItem.model.action;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.info.CartemSetterTotitem;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemEnforceTotitem extends ActionVisitorTemplateEnforce<CartemInfo> {
	
	public VisiCartemEnforceTotitem(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartemInfo enforceHook(CartemInfo recordInfo) {
		InfoSetter<CartemInfo> setter = new CartemSetterTotitem();
		return setter.setAttr(recordInfo);
	}
}
