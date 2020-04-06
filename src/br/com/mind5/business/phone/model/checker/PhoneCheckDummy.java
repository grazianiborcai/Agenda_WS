package br.com.mind5.business.phone.model.checker;

import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class PhoneCheckDummy implements ModelCheckerV1<PhoneInfo> {
	private ModelCheckerV1<PhoneInfo> checker;
	
	
	public PhoneCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PhoneInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PhoneInfo recordInfo) {
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
