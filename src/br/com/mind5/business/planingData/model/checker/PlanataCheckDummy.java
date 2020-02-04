package br.com.mind5.business.planingData.model.checker;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class PlanataCheckDummy implements ModelChecker<PlanataInfo> {
	private ModelChecker<PlanataInfo> checker;
	
	
	public PlanataCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<PlanataInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(PlanataInfo recordInfo) {
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
