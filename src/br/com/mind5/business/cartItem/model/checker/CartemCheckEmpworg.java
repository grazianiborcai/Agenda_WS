package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckEmpworg extends ModelCheckerTemplateForward<CartemInfo, EmpworgInfo> {
	
	public CartemCheckEmpworg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpworgInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpworgCheckExist(option);
	}
	
	
	
	@Override protected EmpworgInfo toForwardClass(CartemInfo baseRecord) {
		return EmpworgInfo.copyFrom(baseRecord);
	}
}
