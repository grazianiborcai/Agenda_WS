package br.com.mind5.business.feeOwner.model.checker;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.checker.FeecatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class FeewnerCheckFeecat extends ModelCheckerTemplateForwardV2<FeewnerInfo, FeecatInfo> {
	
	public FeewnerCheckFeecat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<FeecatInfo> getCheckerHook(ModelCheckerOption option) {
		return new FeecatCheckExist(option);
	}
	
	
	
	@Override protected FeecatInfo toForwardClass(FeewnerInfo baseRecord) {
		return FeecatInfo.copyFrom(baseRecord);
	}
}
