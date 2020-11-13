package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckMatore extends ModelCheckerTemplateForward<CartemInfo, MatoreInfo> {
	
	public CartemCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(CartemInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
