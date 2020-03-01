package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchCopier;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;
import br.com.mind5.payment.systemPartnerSearch.model.checker.SysparchCheckExist;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;

public final class RefumoipCheckSysparch implements ModelChecker<RefumoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SysparchInfo> checker;
	
	
	public RefumoipCheckSysparch(ModelCheckerOption option) {
		checker = new SysparchCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<RefumoipInfo> recordInfos) {
		for (RefumoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(RefumoipInfo recordInfo) {
		return checker.check(SysparchCopier.copyFromRefumoip(recordInfo));
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
