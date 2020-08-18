package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpmatCheckMatarchService extends ModelCheckerTemplateForwardV2<EmpmatInfo, MatarchInfo> {
	
	public EmpmatCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(EmpmatInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
