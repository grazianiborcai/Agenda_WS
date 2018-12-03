package br.com.gda.business.user.model.checker;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.checker.AddressCheckExist;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class UserCheckAddressExist implements ModelChecker<UserInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<AddressInfo> checker;
	
	
	public UserCheckAddressExist(ModelCheckerOption option) {
		checker = new AddressCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<UserInfo> recordInfos) {
		for (UserInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(UserInfo recordInfo) {
		return checker.check(AddressInfo.copyFrom(recordInfo));
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
