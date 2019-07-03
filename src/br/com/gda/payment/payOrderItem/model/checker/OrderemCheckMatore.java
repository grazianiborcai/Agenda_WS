package br.com.gda.payment.payOrderItem.model.checker;

import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.checker.MatoreCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class OrderemCheckMatore implements ModelChecker<PayordemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatoreInfo> checker;
	
	
	public OrderemCheckMatore(ModelCheckerOption option) {
		checker = new MatoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<PayordemInfo> recordInfos) {
		for (PayordemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(PayordemInfo recordInfo) {
		return checker.check(MatoreInfo.copyFrom(recordInfo));
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
