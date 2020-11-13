package br.com.mind5.business.cartItem.model.checker;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CartemCheckEmpmat extends ModelCheckerTemplateForward<CartemInfo, EmpmatInfo> {
	
	public CartemCheckEmpmat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpmatInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmatCheckExist(option);
	}
	
	
	
	@Override protected EmpmatInfo toForwardClass(CartemInfo baseRecord) {
		return EmpmatInfo.copyFrom(baseRecord);
	}
}
