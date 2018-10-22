package br.com.gda.business.phone.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.CountryPhoneInfo;
import br.com.gda.business.masterData.model.checker.CountryPhoneCheckExist;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class PhoneCheckCountryPhone implements ModelChecker<PhoneInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CountryPhoneInfo> checker;
	
	
	public PhoneCheckCountryPhone(ModelCheckerOption option) {
		checker = new CountryPhoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PhoneInfo> recordInfos) {
		for (PhoneInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PhoneInfo recordInfo) {
		return checker.check(CountryPhoneInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailureExplanation() {
		return checker.getFailureExplanation();
	}

	
	
	@Override public int getFailureCode() {
		return checker.getFailureCode();
	}
}
