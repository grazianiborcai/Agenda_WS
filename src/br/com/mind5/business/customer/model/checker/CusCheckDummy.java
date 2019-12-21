package br.com.mind5.business.customer.model.checker;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class CusCheckDummy implements ModelChecker<CusInfo> {
	private ModelChecker<CusInfo> checker;
	
	
	public CusCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
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
