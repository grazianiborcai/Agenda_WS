package br.com.mind5.payment.customerPartner.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchCopier;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;
import br.com.mind5.payment.customerPartnerSearch.model.checker.CusparchCheckExist;

public final class CusparCheckCusparch implements ModelChecker<CusparInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CusparchInfo> checker;
	
	
	public CusparCheckCusparch(ModelCheckerOption option) {
		checker = new CusparchCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusparInfo> recordInfos) {
		for (CusparInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusparInfo recordInfo) {
		return checker.check(CusparchCopier.copyFromCuspar(recordInfo));
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
