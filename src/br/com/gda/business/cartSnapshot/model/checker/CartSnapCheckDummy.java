package br.com.gda.business.cartSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class CartSnapCheckDummy implements ModelChecker<CartSnapInfo> {
	private ModelChecker<CartSnapInfo> checker;
	
	
	public CartSnapCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CartSnapInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CartSnapInfo recordInfo) {
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
