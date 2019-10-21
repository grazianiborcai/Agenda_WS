package br.com.mind5.payment.partnerMoip.multiOrderMoip.model.checker;

import java.util.List;

import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckExist;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

public final class MultmoipCheckCuspar implements ModelChecker<MultmoipInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<CusparInfo> checker;
	
	
	public MultmoipCheckCuspar(ModelCheckerOption option) {
		checker = new CusparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MultmoipInfo> recordInfos) {
		for (MultmoipInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MultmoipInfo recordInfo) {
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
