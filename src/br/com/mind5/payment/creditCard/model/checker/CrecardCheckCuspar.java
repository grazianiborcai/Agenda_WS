package br.com.mind5.payment.creditCard.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;

public final class CrecardCheckCuspar implements ModelChecker<CrecardInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CusparInfo> checker;
	
	
	public CrecardCheckCuspar(ModelCheckerOption option) {
		checker = new CusparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CrecardInfo> recordInfos) {
		for (CrecardInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CrecardInfo recordInfo) {
		return checker.check(CusparInfo.copyFrom(recordInfo));
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
