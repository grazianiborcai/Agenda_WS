package br.com.gda.business.cartItem.model.checker;

import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.common.ModelCherckerTrue;

public final class CartemCheckDummy implements ModelChecker<CartemInfo> {
	private ModelChecker<CartemInfo> checker;
	
	
	public CartemCheckDummy() {
		checker = new ModelCherckerTrue<>();
	}
	
	
	
	@Override public boolean check(List<CartemInfo> recordInfos) {
		return checker.check(recordInfos);
	}

	
	
	@Override public boolean check(CartemInfo recordInfo) {
		return checker.check(recordInfo);
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
