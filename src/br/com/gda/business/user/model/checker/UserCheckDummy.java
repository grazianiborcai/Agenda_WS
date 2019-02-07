package br.com.gda.business.user.model.checker;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class UserCheckDummy implements ModelChecker<UserInfo> {
	private ModelChecker<UserInfo> checker;
	
	
	public UserCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<UserInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(UserInfo recordInfo) {
		return checker.check(recordInfo);
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
