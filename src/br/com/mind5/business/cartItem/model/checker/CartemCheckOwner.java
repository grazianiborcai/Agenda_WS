package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckOwner extends ModelCheckerTemplateForward<CartemInfo, OwnerInfo> {
	
	public CartemCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(CartemInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
