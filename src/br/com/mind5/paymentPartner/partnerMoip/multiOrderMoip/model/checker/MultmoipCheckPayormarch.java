package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchCopier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;
import br.com.mind5.payment.payOrderItemSearch.model.checker.PayormarchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckPayormarch implements ModelChecker<MultmoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PayormarchInfo> checker;
	
	
	public MultmoipCheckPayormarch(ModelCheckerOption option) {
		checker = new PayormarchCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MultmoipInfo> recordInfos) {
		for (MultmoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MultmoipInfo recordInfo) {
		return checker.check(PayormarchCopier.copyFromMultmoip(recordInfo));
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
