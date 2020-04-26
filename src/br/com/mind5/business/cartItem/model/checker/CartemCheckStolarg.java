package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargCopier;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckStolarg extends ModelCheckerTemplateForwardV2<CartemInfo, StolargInfo> {
	
	public CartemCheckStolarg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StolargInfo> getCheckerHook(ModelCheckerOption option) {
		return new StolargCheckExist(option);
	}
	
	
	
	@Override protected StolargInfo toForwardClass(CartemInfo baseRecord) {
		return StolargCopier.copyFromCartem(baseRecord);
	}
}
