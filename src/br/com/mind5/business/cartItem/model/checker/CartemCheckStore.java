package br.com.mind5.business.cartItem.model.checker;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class CartemCheckStore implements ModelChecker<CartemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StoreInfo> checker;
	
	
	public CartemCheckStore(ModelCheckerOption option) {
		checker = new StoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CartemInfo> recordInfos) {
		for (CartemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartemInfo recordInfo) {
		return checker.check(StoreInfo.copyFrom(recordInfo));
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
