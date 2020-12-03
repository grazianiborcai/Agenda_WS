package br.com.mind5.discount.discountCouponItem.model.checker;

import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.discount.discountStore.model.checker.DisoreCheckExistValid;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class DisoupemCheckDisore extends ModelCheckerTemplateForward<DisoupemInfo, DisoreInfo> {
	
	public DisoupemCheckDisore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<DisoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new DisoreCheckExistValid(option);
	}
	
	
	
	@Override protected DisoreInfo toForwardClass(DisoupemInfo baseRecord) {
		return DisoreInfo.copyFrom(baseRecord);
	}
}
