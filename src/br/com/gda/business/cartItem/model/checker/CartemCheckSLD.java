package br.com.gda.business.cartItem.model.checker;

import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.checker.StolevateCheckSLD;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CartemCheckSLD implements ModelChecker<CartemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<StolevateInfo> checker;
	
	
	public CartemCheckSLD(ModelCheckerOption option) {
		checker = new StolevateCheckSLD(option);
	}
	
	
	
	@Override public boolean check(List<CartemInfo> recordInfos) {
		for (CartemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartemInfo recordInfo) {
		return checker.check(StolevateInfo.copyFrom(recordInfo));
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
