package br.com.mind5.payment.storePartner.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.checker.PayparCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparCheckPaypar implements ModelChecker<StoparInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PayparInfo> checker;
	
	
	public StoparCheckPaypar(ModelCheckerOption option) {
		checker = new PayparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<StoparInfo> recordInfos) {
		for (StoparInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(StoparInfo recordInfo) {
		return checker.check(PayparInfo.copyFrom(recordInfo));
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
