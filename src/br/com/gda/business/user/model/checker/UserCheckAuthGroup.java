package br.com.gda.business.user.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.AuthGroupInfo;
import br.com.gda.business.masterData.model.checker.AuthGroupCheckExist;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class UserCheckAuthGroup implements ModelChecker<UserInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<AuthGroupInfo> checker;
	
	
	public UserCheckAuthGroup(ModelCheckerOption option) {
		checker = new AuthGroupCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<UserInfo> recordInfos) {
		for (UserInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(UserInfo recordInfo) {
		return checker.check(AuthGroupInfo.copyFrom(recordInfo));
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
