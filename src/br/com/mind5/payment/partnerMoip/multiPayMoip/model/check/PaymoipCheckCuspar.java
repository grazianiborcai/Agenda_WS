package br.com.mind5.payment.partnerMoip.multiPayMoip.model.check;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

public final class PaymoipCheckCuspar implements ModelChecker<PaymoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CusparInfo> checker;
	
	
	public PaymoipCheckCuspar(ModelCheckerOption option) {
		checker = new CusparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PaymoipInfo> recordInfos) {
		for (PaymoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PaymoipInfo recordInfo) {
		return checker.check(recordInfo.cusparData);
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
