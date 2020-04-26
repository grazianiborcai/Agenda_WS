package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckEmposarch extends ModelCheckerTemplateForwardV2<CartemInfo, EmposarchInfo> {
	
	public CartemCheckEmposarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmposarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmposarchCheckExist(option);
	}
	
	
	
	@Override protected EmposarchInfo toForwardClass(CartemInfo baseRecord) {
		return EmposarchInfo.copyFrom(baseRecord);
	}
}
