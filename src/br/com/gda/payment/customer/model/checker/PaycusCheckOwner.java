package br.com.gda.payment.customer.model.checker;

import java.util.List;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.checker.OwnerCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class PaycusCheckOwner implements ModelChecker<PaycusInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<OwnerInfo> checker;
	
	
	public PaycusCheckOwner(ModelCheckerOption option) {
		checker = new OwnerCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PaycusInfo> recordInfos) {
		for (PaycusInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PaycusInfo recordInfo) {
		return checker.check(OwnerInfo.copyFrom(recordInfo));
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
