package br.com.mind5.payment.countryPartner.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class CounparCheckDummy implements ModelChecker<CounparInfo> {
	private ModelChecker<CounparInfo> checker;
	
	
	public CounparCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CounparInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CounparInfo recordInfo) {
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
