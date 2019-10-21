package br.com.mind5.business.address.model.checker;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCherckerTrue;

public final class AddressCheckDummy implements ModelChecker<AddressInfo> {
	private ModelChecker<AddressInfo> checker;
	
	
	public AddressCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<AddressInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(AddressInfo recordInfo) {
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
