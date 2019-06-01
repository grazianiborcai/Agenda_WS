package br.com.gda.business.cartSnapshot_.model.checker;

import java.util.List;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.checker.UserCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartSnapCheckUser implements ModelChecker<CartSnapInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<UserInfo> checker;
	
	
	public CartSnapCheckUser(ModelCheckerOption option) {
		checker = new UserCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CartSnapInfo> recordInfos) {
		for (CartSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(CartSnapInfo recordInfo) {
		return checker.check(UserInfo.copyFrom(recordInfo));
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
