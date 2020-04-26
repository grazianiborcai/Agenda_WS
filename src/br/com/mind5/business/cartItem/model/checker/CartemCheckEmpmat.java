package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CartemCheckEmpmat extends ModelCheckerTemplateForwardV2<CartemInfo, EmpmatInfo> {
	
	public CartemCheckEmpmat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpmatInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmatCheckExist(option);
	}
	
	
	
	@Override protected EmpmatInfo toForwardClass(CartemInfo baseRecord) {
		return EmpmatInfo.copyFrom(baseRecord);
	}
}
