package br.com.mind5.business.cartItem.model.checker;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.planingDataSearch.info.PlanarchCopier;
import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.model.checker.PlanarchCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class CartemCheckPlanarch implements ModelChecker<CartemInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<PlanarchInfo> checker;
	
	
	public CartemCheckPlanarch(ModelCheckerOption option) {
		checker = new PlanarchCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CartemInfo> recordInfos) {
		for (CartemInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CartemInfo recordInfo) {
		return checker.check(PlanarchCopier.copyFromCartem(recordInfo));
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
