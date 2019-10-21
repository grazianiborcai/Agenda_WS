package br.com.mind5.security.userSnapshot.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapCheckUser implements ModelChecker<UserapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UserInfo> checker;
	
	
	public UserapCheckUser(ModelCheckerOption option) {
		checker = new UserCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<UserapInfo> recordInfos) {
		for (UserapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(UserapInfo recordInfo) {
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
