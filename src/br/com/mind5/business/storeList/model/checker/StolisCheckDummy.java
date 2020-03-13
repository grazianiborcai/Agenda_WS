package br.com.mind5.business.storeList.model.checker;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class StolisCheckDummy implements ModelChecker<StolisInfo> {
	private ModelChecker<StolisInfo> checker;
	
	
	public StolisCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<StolisInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(StolisInfo recordInfo) {
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
