package br.com.gda.security.userPassword.model.checker;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.checker.UserCheckUsernameExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdCheckUsername implements ModelChecker<UpswdInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UserInfo> checker;
	
	
	public UpswdCheckUsername(ModelCheckerOption option) {
		checker = new UserCheckUsernameExist(option);
	}
	
	
	
	@Override public boolean check(List<UpswdInfo> recordInfos) {
		for (UpswdInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(UpswdInfo recordInfo) {
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
