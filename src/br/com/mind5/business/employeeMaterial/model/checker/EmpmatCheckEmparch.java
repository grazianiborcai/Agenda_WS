package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.employeeSearch.model.checker.EmparchCheckExistSytotauh;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class EmpmatCheckEmparch extends ModelCheckerTemplateForward<EmpmatInfo, EmparchInfo> {
	
	public EmpmatCheckEmparch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmparchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmparchCheckExistSytotauh(option);
	}
	
	
	
	@Override protected EmparchInfo toForwardClass(EmpmatInfo baseRecord) {
		return EmparchInfo.copyFrom(baseRecord);
	}
}
