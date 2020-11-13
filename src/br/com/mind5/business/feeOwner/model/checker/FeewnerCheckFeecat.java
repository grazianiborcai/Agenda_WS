package br.com.mind5.business.feeOwner.model.checker;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;
import br.com.mind5.masterData.feeCategory.model.checker.FeecatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class FeewnerCheckFeecat extends ModelCheckerTemplateForward<FeewnerInfo, FeecatInfo> {
	
	public FeewnerCheckFeecat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<FeecatInfo> getCheckerHook(ModelCheckerOption option) {
		return new FeecatCheckExist(option);
	}
	
	
	
	@Override protected FeecatInfo toForwardClass(FeewnerInfo baseRecord) {
		return FeecatInfo.copyFrom(baseRecord);
	}
}
