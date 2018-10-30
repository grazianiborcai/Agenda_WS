package br.com.gda.business.cart.model.checker;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.business.storeLeaveDate.model.checker.StoreLDateCheckSLD;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartCheckSLD implements ModelChecker<CartInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreLDateInfo> checker;
	
	
	public CartCheckSLD(ModelCheckerOption option) {
		checker = new StoreLDateCheckSLD(option);
	}
	
	
	
	@Override public boolean check(List<CartInfo> recordInfos) {
		for (CartInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartInfo recordInfo) {
		return checker.check(StoreLDateInfo.copyFrom(recordInfo));
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
