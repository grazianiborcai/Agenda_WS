package br.com.gda.business.feeStore.model.checker;

import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.model.checker.FeeCategCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class FeeStoreCheckFeeCateg implements ModelChecker<FeeStoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<FeeCategInfo> checker;
	
	
	public FeeStoreCheckFeeCateg(ModelCheckerOption option) {
		checker = new FeeCategCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<FeeStoreInfo> recordInfos) {
		for (FeeStoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(FeeStoreInfo recordInfo) {
		return checker.check(FeeCategInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailureExplanation() {
		return checker.getFailureExplanation();
	}

	
	
	@Override public int getFailureCode() {
		return checker.getFailureCode();
	}
}
