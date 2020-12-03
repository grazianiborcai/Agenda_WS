package br.com.mind5.discount.discountCouponItem.model.checker;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class DisoupemCheckOwner extends ModelCheckerTemplateForward<DisoupemInfo, OwnerInfo> {
	
	public DisoupemCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(DisoupemInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
