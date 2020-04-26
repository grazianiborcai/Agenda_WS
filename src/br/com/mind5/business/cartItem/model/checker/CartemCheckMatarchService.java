package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckMatarchService extends ModelCheckerTemplateForwardV2<CartemInfo, MatarchInfo> {
	
	public CartemCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(CartemInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
