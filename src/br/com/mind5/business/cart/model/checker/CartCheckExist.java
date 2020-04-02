package br.com.mind5.business.cart.model.checker;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.business.cart.model.action.StdCartSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartCheckExist extends ModelCheckerTemplateAction<CartInfo, CartInfo> {
	
	public CartCheckExist(ModelCheckerOption option) {
		super(option, CartInfo.class);
	}
	

	
	@Override protected ActionStdV1<CartInfo> buildActionHook(DeciTreeOption<CartInfo> option) {
		ActionStdV1<CartInfo> select = new StdCartSelect(option);
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_HEADER_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_HEADER_NOT_FOUND;
	}
}
