package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class EmpmatCheckMatarchService extends ModelCheckerTemplateForward<EmpmatInfo, MatarchInfo> {
	
	public EmpmatCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(EmpmatInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
