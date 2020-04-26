package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckEmp extends ModelCheckerTemplateForwardV2<CartemInfo, EmpInfo> {
	
	public CartemCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(CartemInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
