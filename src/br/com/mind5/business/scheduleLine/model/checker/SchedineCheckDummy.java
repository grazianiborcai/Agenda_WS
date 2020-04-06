package br.com.mind5.business.scheduleLine.model.checker;

import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class SchedineCheckDummy implements ModelCheckerV1<SchedineInfo> {
	private ModelCheckerV1<SchedineInfo> checker;
	
	
	public SchedineCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<SchedineInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(SchedineInfo recordInfo) {
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
