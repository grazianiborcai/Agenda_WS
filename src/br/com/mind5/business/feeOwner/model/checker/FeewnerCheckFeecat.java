package br.com.mind5.business.feeOwner.model.checker;

import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.checker.FeecatCheckExist;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class FeewnerCheckFeecat implements ModelCheckerV1<FeewnerInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<FeecatInfo> checker;
	
	
	public FeewnerCheckFeecat(ModelCheckerOption option) {
		checker = new FeecatCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<FeewnerInfo> recordInfos) {
		for (FeewnerInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(FeewnerInfo recordInfo) {
		return checker.check(FeecatInfo.copyFrom(recordInfo));
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
