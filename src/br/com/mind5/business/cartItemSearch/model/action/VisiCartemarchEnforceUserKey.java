package br.com.mind5.business.cartItemSearch.model.action;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.info.CartemarchSetterUserKey;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCartemarchEnforceUserKey extends ActionVisitorTemplateEnforce<CartemarchInfo> {
	
	public VisiCartemarchEnforceUserKey(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartemarchInfo enforceHook(CartemarchInfo recordInfo) {
		InfoSetter<CartemarchInfo> setter = new CartemarchSetterUserKey();
		return setter.setAttr(recordInfo);
	}
}
