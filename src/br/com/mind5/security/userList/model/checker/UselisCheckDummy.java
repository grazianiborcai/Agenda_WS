package br.com.mind5.security.userList.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisCheckDummy implements ModelCheckerV1<UselisInfo> {
	private ModelCheckerV1<UselisInfo> checker;
	
	
	public UselisCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<UselisInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(UselisInfo recordInfo) {
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
