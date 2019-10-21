package br.com.mind5.business.form.formAddress.model.checker;

import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.masterData.info.CountryInfo;
import br.com.mind5.business.masterData.model.checker.CountryCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class FormAddressCheckCountry implements ModelChecker<FormAddressInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CountryInfo> checker;
	
	
	public FormAddressCheckCountry(ModelCheckerOption option) {
		checker = new CountryCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<FormAddressInfo> recordInfos) {
		for (FormAddressInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(FormAddressInfo recordInfo) {
		return checker.check(CountryInfo.copyFrom(recordInfo));
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
