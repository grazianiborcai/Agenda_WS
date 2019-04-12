package br.com.gda.business.cart.model.checker;

import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.business.employeeLeaveDate.model.checker.EmplevateCheckELD;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartCheckELD implements ModelChecker<CartInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmplevateInfo> checker;
	
	
	public CartCheckELD(ModelCheckerOption option) {
		checker = new EmplevateCheckELD(option);
	}
	
	
	
	@Override public boolean check(List<CartInfo> recordInfos) {
		for (CartInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartInfo recordInfo) {
		return checker.check(EmplevateInfo.copyFrom(recordInfo));
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
