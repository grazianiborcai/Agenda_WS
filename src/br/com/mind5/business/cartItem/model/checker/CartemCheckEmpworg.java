package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckEmpworg extends ModelCheckerTemplateForwardV2<CartemInfo, EmpworgInfo> {
	
	public CartemCheckEmpworg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpworgInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpworgCheckExist(option);
	}
	
	
	
	@Override protected EmpworgInfo toForwardClass(CartemInfo baseRecord) {
		return EmpworgInfo.copyFrom(baseRecord);
	}
}
