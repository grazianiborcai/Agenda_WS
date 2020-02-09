package br.com.mind5.payment.customerPartner.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckDummy implements ModelChecker<CusparInfo> {
	private ModelChecker<CusparInfo> checker;
	
	
	public CusparCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CusparInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CusparInfo recordInfo) {
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
