package br.com.mind5.discount.discountCouponItem.model.checker;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.masterData.language.info.LanguInfo;
import br.com.mind5.masterData.language.model.checker.LanguCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class DisoupemCheckLangu extends ModelCheckerTemplateForward<DisoupemInfo, LanguInfo> {
	
	public DisoupemCheckLangu(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<LanguInfo> getCheckerHook(ModelCheckerOption option) {
		return new LanguCheckExist(option);
	}
	
	
	
	@Override protected LanguInfo toForwardClass(DisoupemInfo baseRecord) {
		return LanguInfo.copyFrom(baseRecord);
	}
}
