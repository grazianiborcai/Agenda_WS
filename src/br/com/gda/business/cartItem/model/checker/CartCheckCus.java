package br.com.gda.business.cartItem.model.checker;

import java.util.List;

import br.com.gda.business.cartItem.info.CartInfo;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.checker.CusCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartCheckCus implements ModelChecker<CartInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CusInfo> checker;
	
	
	public CartCheckCus(ModelCheckerOption option) {
		checker = new CusCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CartInfo> recordInfos) {
		for (CartInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartInfo recordInfo) {
		return checker.check(CusInfo.copyFrom(recordInfo));
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
