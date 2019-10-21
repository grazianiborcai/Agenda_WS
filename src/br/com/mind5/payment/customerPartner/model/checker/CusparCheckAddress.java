package br.com.mind5.payment.customerPartner.model.checker;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class CusparCheckAddress implements ModelChecker<CusparInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<AddressInfo> checker;
	
	
	public CusparCheckAddress(ModelCheckerOption option) {
		checker = new AddressCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusparInfo> recordInfos) {
		for (CusparInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusparInfo recordInfo) {
		return checker.check(AddressCopier.copyFromCuspar(recordInfo));
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
