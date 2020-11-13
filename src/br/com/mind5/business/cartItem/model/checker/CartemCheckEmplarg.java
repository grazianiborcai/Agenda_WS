package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargCopier;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckEmplarg extends ModelCheckerTemplateForward<CartemInfo, EmplargInfo> {
	
	public CartemCheckEmplarg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmplargInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmplargCheckExist(option);
	}
	
	
	
	@Override protected EmplargInfo toForwardClass(CartemInfo baseRecord) {
		return EmplargCopier.copyFromCartem(baseRecord);
	}
}
