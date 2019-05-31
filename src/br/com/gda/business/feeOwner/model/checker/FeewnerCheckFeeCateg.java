package br.com.gda.business.feeOwner.model.checker;

import java.util.List;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.model.checker.FeeCategCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class FeewnerCheckFeeCateg implements ModelChecker<FeewnerInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<FeeCategInfo> checker;
	
	
	public FeewnerCheckFeeCateg(ModelCheckerOption option) {
		checker = new FeeCategCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<FeewnerInfo> recordInfos) {
		for (FeewnerInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(FeewnerInfo recordInfo) {
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
