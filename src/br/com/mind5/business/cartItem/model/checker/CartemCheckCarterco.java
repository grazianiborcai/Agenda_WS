package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.checker.CartercoCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckCarterco extends ModelCheckerTemplateForwardV2<CartemInfo, CartercoInfo> {
	
	public CartemCheckCarterco(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CartercoInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartercoCheckExist(option);
	}
	
	
	
	@Override protected CartercoInfo toForwardClass(CartemInfo baseRecord) {
		return CartercoInfo.copyFrom(baseRecord);
	}
}
