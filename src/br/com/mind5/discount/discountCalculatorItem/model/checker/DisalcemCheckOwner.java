package br.com.mind5.discount.discountCalculatorItem.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class DisalcemCheckOwner extends ModelCheckerTemplateForward<DisalcemInfo, OwnerInfo> {
	
	public DisalcemCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(DisalcemInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
