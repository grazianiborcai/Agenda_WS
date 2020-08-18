package br.com.mind5.business.employeeMaterial.model.checker;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.employeeMaterialSearch.model.checker.EmpmarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class EmpmatCheckEmpmarch extends ModelCheckerTemplateForwardV2<EmpmatInfo, EmpmarchInfo> {
	
	public EmpmatCheckEmpmarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpmarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmarchCheckExist(option);
	}
	
	
	
	@Override protected EmpmarchInfo toForwardClass(EmpmatInfo baseRecord) {
		return EmpmarchInfo.copyFrom(baseRecord);
	}
}
