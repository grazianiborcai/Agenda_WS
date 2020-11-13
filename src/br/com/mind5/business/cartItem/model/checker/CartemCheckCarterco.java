package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.checker.CartercoCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckCarterco extends ModelCheckerTemplateForward<CartemInfo, CartercoInfo> {
	
	public CartemCheckCarterco(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CartercoInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartercoCheckExist(option);
	}
	
	
	
	@Override protected CartercoInfo toForwardClass(CartemInfo baseRecord) {
		return CartercoInfo.copyFrom(baseRecord);
	}
}
