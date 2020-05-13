package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.checker.SchederveCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckSchederve extends ModelCheckerTemplateForwardV2<CartemInfo, SchederveInfo> {
	
	public CartemCheckSchederve(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchederveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchederveCheckExist(option);
	}
	
	
	
	@Override protected SchederveInfo toForwardClass(CartemInfo baseRecord) {
		return SchederveInfo.copyFrom(baseRecord);
	}
}
