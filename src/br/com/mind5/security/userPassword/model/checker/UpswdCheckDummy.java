package br.com.mind5.security.userPassword.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdCheckDummy implements ModelChecker<UpswdInfo> {
	private ModelChecker<UpswdInfo> checker;
	
	
	public UpswdCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<UpswdInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(UpswdInfo recordInfo) {
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
