package br.com.mind5.business.cartCounter.model.action;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.cartCounter.info.CartouSetterCartem;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartouVisiObfuscateCartem extends ActionVisitorTemplateEnforce<CartouInfo> {
	
	public CartouVisiObfuscateCartem(DeciTreeOption<CartouInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CartouInfo enforceHook(CartouInfo recordInfo) {
		InfoSetter<CartouInfo> setter = new CartouSetterCartem();
		return setter.setAttr(recordInfo);
	}
}
