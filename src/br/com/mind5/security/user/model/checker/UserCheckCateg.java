package br.com.mind5.security.user.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.checker.UserCategCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.security.user.info.UserInfo;

public final class UserCheckCateg implements ModelChecker<UserInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<UserCategInfo> checker;
	
	
	public UserCheckCateg(ModelCheckerOption option) {
		checker = new UserCategCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<UserInfo> recordInfos) {
		for (UserInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(UserInfo recordInfo) {
		return checker.check(UserCategInfo.copyFrom(recordInfo));
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
