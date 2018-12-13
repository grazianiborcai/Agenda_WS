package br.com.gda.business.userSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.checker.UserCheckExist;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class UserSnapCheckUser implements ModelChecker<UserSnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UserInfo> checker;
	
	
	public UserSnapCheckUser(ModelCheckerOption option) {
		checker = new UserCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<UserSnapInfo> recordInfos) {
		for (UserSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(UserSnapInfo recordInfo) {
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
