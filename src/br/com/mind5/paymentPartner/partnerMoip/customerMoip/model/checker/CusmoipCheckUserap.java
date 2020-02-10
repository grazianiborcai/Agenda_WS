package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.security.userSnapshot.info.UserapCopier;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckExist;

public final class CusmoipCheckUserap implements ModelChecker<CusmoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<UserapInfo> checker;
	
	
	public CusmoipCheckUserap(ModelCheckerOption option) {
		checker = new UserapCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusmoipInfo> recordInfos) {
		for (CusmoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusmoipInfo recordInfo) {
		return checker.check(UserapCopier.copyFromCusmoip(recordInfo));
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
