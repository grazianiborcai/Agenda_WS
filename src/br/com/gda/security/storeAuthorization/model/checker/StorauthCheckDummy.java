package br.com.gda.security.storeAuthorization.model.checker;

import java.util.List;

import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;
import br.com.gda.security.storeAuthorization.info.StorauthInfo;

public final class StorauthCheckDummy implements ModelChecker<StorauthInfo> {
	private ModelChecker<StorauthInfo> checker;
	
	
	public StorauthCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<StorauthInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(StorauthInfo recordInfo) {
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
