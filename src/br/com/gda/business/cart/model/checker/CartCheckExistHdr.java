package br.com.gda.business.cart.model.checker;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartCheckExistHdr implements ModelChecker<CartInfo> {
	private CartCheckHasItem checker;
	
	
	public CartCheckExistHdr(ModelCheckerOption option) {
		checker = new CartCheckHasItem(option);
	}

	
	
	@Override public boolean check(List<CartInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CartInfo recordInfo) {
		return checker.check(recordInfo);
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
