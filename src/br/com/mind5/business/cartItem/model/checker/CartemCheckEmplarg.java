package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargCopier;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckEmplarg extends ModelCheckerTemplateForwardV2<CartemInfo, EmplargInfo> {
	
	public CartemCheckEmplarg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmplargInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmplargCheckExist(option);
	}
	
	
	
	@Override protected EmplargInfo toForwardClass(CartemInfo baseRecord) {
		return EmplargCopier.copyFromCartem(baseRecord);
	}
}
