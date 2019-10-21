package br.com.mind5.business.customer.model.checker;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class CusCheckAddressExist implements ModelChecker<CusInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<AddressInfo> checker;
	
	
	public CusCheckAddressExist(ModelCheckerOption option) {
		checker = new AddressCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusInfo> recordInfos) {
		for (CusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusInfo recordInfo) {
		return checker.check(AddressInfo.copyFrom(recordInfo));
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
