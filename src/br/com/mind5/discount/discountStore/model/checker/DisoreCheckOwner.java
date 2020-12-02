package br.com.mind5.discount.discountStore.model.checker;

import br.com.mind5.discount.discountStore.info.DisoreInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class DisoreCheckOwner extends ModelCheckerTemplateForward<DisoreInfo, OwnerInfo> {
	
	public DisoreCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(DisoreInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
