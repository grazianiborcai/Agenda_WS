package br.com.gda.business.phone.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.AreaPhoneInfo;
import br.com.gda.business.masterData.model.checker.AreaPhoneCheckExist;
import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class PhoneCheckArea implements ModelChecker<PhoneInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<AreaPhoneInfo> checker;
	
	
	public PhoneCheckArea(ModelCheckerOption option) {
		checker = new AreaPhoneCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PhoneInfo> recordInfos) {
		for (PhoneInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PhoneInfo recordInfo) {
		return checker.check(AreaPhoneInfo.copyFrom(recordInfo));
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
