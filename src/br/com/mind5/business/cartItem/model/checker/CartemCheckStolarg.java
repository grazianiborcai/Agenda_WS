package br.com.mind5.business.cartItem.model.checker;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargCopier;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class CartemCheckStolarg implements ModelChecker<CartemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StolargInfo> checker;
	
	
	public CartemCheckStolarg(ModelCheckerOption option) {
		checker = new StolargCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CartemInfo> recordInfos) {
		for (CartemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartemInfo recordInfo) {
		return checker.check(StolargCopier.copyFromCartem(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
