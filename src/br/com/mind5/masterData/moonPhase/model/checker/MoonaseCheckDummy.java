package br.com.mind5.masterData.moonPhase.model.checker;

import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class MoonaseCheckDummy implements ModelCheckerV1<MoonaseInfo> {
	private ModelCheckerV1<MoonaseInfo> checker;
	
	
	public MoonaseCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<MoonaseInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(MoonaseInfo recordInfo) {
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
