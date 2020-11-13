package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckMatarchService extends ModelCheckerTemplateForward<CartemInfo, MatarchInfo> {
	
	public CartemCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(CartemInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
