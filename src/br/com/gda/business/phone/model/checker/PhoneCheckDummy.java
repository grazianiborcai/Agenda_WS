package br.com.gda.business.phone.model.checker;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class PhoneCheckDummy implements ModelChecker<PhoneInfo> {
	private ModelChecker<PhoneInfo> checker;
	
	
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
