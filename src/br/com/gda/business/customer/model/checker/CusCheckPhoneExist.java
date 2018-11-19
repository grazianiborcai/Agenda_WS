package br.com.gda.business.customer.model.checker;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.checker.PhoneCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CusCheckPhoneExist implements ModelChecker<CusInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PhoneInfo> checker;
	
	
	public CusCheckPhoneExist(ModelCheckerOption option) {
		checker = new PhoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		for (CusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
		return checker.check(PhoneInfo.copyFrom(recordInfo));
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
