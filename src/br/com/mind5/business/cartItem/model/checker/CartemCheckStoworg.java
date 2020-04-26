package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckStoworg extends ModelCheckerTemplateForwardV2<CartemInfo, StoworgInfo> {
	
	public CartemCheckStoworg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StoworgInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoworgCheckExist(option);
	}
	
	
	
	@Override protected StoworgInfo toForwardClass(CartemInfo baseRecord) {
		return StoworgInfo.copyFrom(baseRecord);
	}
}
