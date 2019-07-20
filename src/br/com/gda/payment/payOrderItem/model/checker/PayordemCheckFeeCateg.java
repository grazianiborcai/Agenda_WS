package br.com.gda.payment.payOrderItem.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.model.checker.FeeCategCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PayordemCheckFeeCateg implements ModelChecker<PayordemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<FeeCategInfo> checker;
	
	
	public PayordemCheckFeeCateg(ModelCheckerOption option) {
		checker = new FeeCategCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayordemInfo> recordInfos) {
		for (PayordemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PayordemInfo recordInfo) {
		return checker.check(FeeCategInfo.copyFrom(recordInfo));
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
