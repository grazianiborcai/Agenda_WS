package br.com.gda.payment.customerPartner.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.checker.PayparCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.customerPartner.info.CusparInfo;

public final class CusparCheckPaypar implements ModelChecker<CusparInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PayparInfo> checker;
	
	
	public CusparCheckPaypar(ModelCheckerOption option) {
		checker = new PayparCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CusparInfo> recordInfos) {
		for (CusparInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CusparInfo recordInfo) {
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
