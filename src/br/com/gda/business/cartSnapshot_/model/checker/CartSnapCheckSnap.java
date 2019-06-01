package br.com.gda.business.cartSnapshot_.model.checker;

import java.util.List;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.business.snapshot_.model.checker.SnapCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartSnapCheckSnap implements ModelChecker<CartSnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SnapInfo> checker;
	
	
	public CartSnapCheckSnap(ModelCheckerOption option) {
		checker = new SnapCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CartSnapInfo> recordInfos) {
		for (CartSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartSnapInfo recordInfo) {
		return checker.check(SnapInfo.copyFrom(recordInfo));
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
