package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckExistEmp;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class EmpmatCheckEmpmarch extends ModelCheckerTemplateForward<EmpmatInfo, EmpmarchInfo> {
	
	public EmpmatCheckEmpmarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpmarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmarchCheckExistEmp(option);
	}
	
	
	
	@Override protected EmpmarchInfo toForwardClass(EmpmatInfo baseRecord) {
		return EmpmarchInfo.copyFrom(baseRecord);
	}
}
