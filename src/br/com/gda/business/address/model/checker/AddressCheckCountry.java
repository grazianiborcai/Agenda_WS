package br.com.gda.business.address.model.checker;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.masterData.info.CountryInfo;
import br.com.gda.business.masterData.model.checker.CountryCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class AddressCheckCountry implements ModelChecker<AddressInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CountryInfo> checker;
	
	
	public AddressCheckCountry(ModelCheckerOption option) {
		checker = new CountryCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<AddressInfo> recordInfos) {
		for (AddressInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(AddressInfo recordInfo) {
		return checker.check(CountryInfo.copyFrom(recordInfo));
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
