package br.com.mind5.business.materialList.model.checker;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class MatlisCheckDummy implements ModelChecker<MatlisInfo> {
	private ModelChecker<MatlisInfo> checker;
	
	
	public MatlisCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<MatlisInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(MatlisInfo recordInfo) {
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
