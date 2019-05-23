package br.com.gda.business.cartSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.business.cart.model.checker.CartCheckExist;
import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartSnapCheckCartItm implements ModelChecker<CartSnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CartInfo> checker;
	
	
	public CartSnapCheckCartItm(ModelCheckerOption option) {
		checker = new CartCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CartSnapInfo> recordInfos) {
		for (CartSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartSnapInfo recordInfo) {
		return checker.check(CartInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
