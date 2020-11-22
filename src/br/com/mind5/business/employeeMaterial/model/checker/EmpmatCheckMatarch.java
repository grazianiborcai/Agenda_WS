package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistSytotauh;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class EmpmatCheckMatarch extends ModelCheckerTemplateForward<EmpmatInfo, MatarchInfo> {
	
	public EmpmatCheckMatarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistSytotauh(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(EmpmatInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
