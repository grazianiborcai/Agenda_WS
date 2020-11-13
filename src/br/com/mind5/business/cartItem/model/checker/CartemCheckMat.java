package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckMat extends ModelCheckerTemplateForward<CartemInfo, MatInfo> {
	
	public CartemCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(CartemInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
